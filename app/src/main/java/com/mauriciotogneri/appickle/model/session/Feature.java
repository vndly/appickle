package com.mauriciotogneri.appickle.model.session;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import gherkin.ast.ScenarioDefinition;

public class Feature
{
    private final gherkin.ast.Feature feature;

    public Feature(gherkin.ast.Feature feature)
    {
        this.feature = feature;
    }

    public String name()
    {
        return feature.getName();
    }

    public String description()
    {
        StringBuilder builder = new StringBuilder();
        String description = feature.getDescription();

        if (!TextUtils.isEmpty(description))
        {
            String[] parts = description.split("\n");

            for (String part : parts)
            {
                if (builder.length() != 0)
                {
                    builder.append("\n");
                }

                builder.append(part.trim());
            }
        }

        return builder.toString();
    }

    public List<Scenario> scenarios()
    {
        List<Scenario> result = new ArrayList<>();

        for (ScenarioDefinition scenario : feature.getChildren())
        {
            result.add(new Scenario(scenario));
        }

        return result;
    }
}