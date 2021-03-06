package com.mauriciotogneri.appickle.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.mauriciotogneri.appickle.R;
import com.mauriciotogneri.appickle.adapters.StepAdapter.ViewHolder;
import com.mauriciotogneri.appickle.base.BaseListAdapter;
import com.mauriciotogneri.appickle.model.session.Step;

import java.util.List;

public class StepAdapter extends BaseListAdapter<Step, ViewHolder>
{
    public StepAdapter(Context context, List<Step> steps)
    {
        super(context, R.layout.row_step, steps);
    }

    @Override
    protected ViewHolder viewHolder(View view)
    {
        return new ViewHolder(view);
    }

    @Override
    protected void fillView(ViewHolder viewHolder, Step step)
    {
        viewHolder.content.setText(Html.fromHtml(step.content()));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView content;

        public ViewHolder(View view)
        {
            super(view);

            Animation fadeInAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_in);
            view.startAnimation(fadeInAnimation);

            this.content = (TextView) view.findViewById(R.id.step_content);
        }
    }
}