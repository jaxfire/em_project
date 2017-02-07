package com.jaxfire.james_ash_earthmiles.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllRewardData
{
    @SerializedName("count")
    @Expose
    private String count;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("previous")
    @Expose
    private String previous;

    @SerializedName("results")
    @Expose
    private RewardItem[] results;

    //Getters and setters
    public RewardItem[] getResults ()
    {
        return results;
    }

    public void setResults (RewardItem[] results)
    {
        this.results = results;
    }

    public String getPrevious ()
{
    return previous;
}

    public void setPrevious (String previous)
    {
        this.previous = previous;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getNext ()
{
    return next;
}

    public void setNext (String next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        return "All Rewards Data. Size: " + count;
    }
}
