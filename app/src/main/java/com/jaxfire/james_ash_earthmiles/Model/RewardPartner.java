package com.jaxfire.james_ash_earthmiles.Model;


public class RewardPartner
{
    private String id;

    private String name;

    private String image;

    private String image_web;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getImage_web ()
    {
        return image_web;
    }

    public void setImage_web (String image_web)
    {
        this.image_web = image_web;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", name = "+name+", image = "+image+", image_web = "+image_web+"]";
    }
}
