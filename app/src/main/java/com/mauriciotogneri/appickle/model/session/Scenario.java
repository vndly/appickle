package com.mauriciotogneri.appickle.model.session;

import android.text.TextUtils;

import gherkin.ast.ScenarioDefinition;

public class Scenario
{
    private final ScenarioDefinition scenario;

    public Scenario(ScenarioDefinition scenario)
    {
        this.scenario = scenario;
    }

    public String name()
    {
        return scenario.getName();
    }

    public String description()
    {
        StringBuilder builder = new StringBuilder();
        String description = scenario.getDescription();

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
}