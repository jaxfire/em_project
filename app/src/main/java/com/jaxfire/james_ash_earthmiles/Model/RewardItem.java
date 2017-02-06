package com.jaxfire.james_ash_earthmiles.Model;


import android.graphics.Bitmap;

public class RewardItem implements Comparable<RewardItem>
{
    private String image_content_height;

    private String buy_now_text;

    private String availing;

    private String location;

    private String maximum_redeemable_units_per_user;

    private RewardPartner reward_partner;

    private String image_web;

    private String image_320x280;

    private String id;

    private String is_new;

    private String short_description;

    private String[] locations;

    private String validity;

    private String expiry_date_absolute;

    private String is_challenge;

    private String points;

    private String timing;

    private String image_content_width;

    private String image;

    private String has_unallotted_vouchers;

    private String pound_value_text;

    private String highlights;

    private String category;

    private String gifting_enabled;

    private String points_for_gifting;

    private String has_in_app_purchase;

    private Bitmap loadedImage;

    private boolean hasImageLoaded;

    public String getImage_content_height ()
    {
        return image_content_height;
    }

    public void setImage_content_height (String image_content_height)
    {
        this.image_content_height = image_content_height;
    }

    public String getBuy_now_text ()
    {
        return buy_now_text;
    }

    public void setBuy_now_text (String buy_now_text)
    {
        this.buy_now_text = buy_now_text;
    }

    public String getAvailing ()
    {
        return availing;
    }

    public void setAvailing (String availing)
    {
        this.availing = availing;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getMaximum_redeemable_units_per_user ()
    {
        return maximum_redeemable_units_per_user;
    }

    public void setMaximum_redeemable_units_per_user (String maximum_redeemable_units_per_user)
    {
        this.maximum_redeemable_units_per_user = maximum_redeemable_units_per_user;
    }

    public RewardPartner getReward_partner ()
    {
        return reward_partner;
    }

    public void setReward_partner (RewardPartner reward_partner)
    {
        this.reward_partner = reward_partner;
    }

    public String getImage_web ()
    {
        return image_web;
    }

    public void setImage_web (String image_web)
    {
        this.image_web = image_web;
    }

    public String getImage_320x280 ()
    {
        return image_320x280;
    }

    public void setImage_320x280 (String image_320x280)
    {
        this.image_320x280 = image_320x280;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIs_new ()
    {
        return is_new;
    }

    public void setIs_new (String is_new)
    {
        this.is_new = is_new;
    }

    public String getShort_description ()
    {
        return short_description;
    }

    public void setShort_description (String short_description)
    {
        this.short_description = short_description;
    }

    public String[] getLocations ()
    {
        return locations;
    }

    public void setLocations (String[] locations)
    {
        this.locations = locations;
    }

    public String getValidity ()
    {
        return validity;
    }

    public void setValidity (String validity)
    {
        this.validity = validity;
    }

    public String getExpiry_date_absolute ()
    {
        return expiry_date_absolute;
    }

    public void setExpiry_date_absolute (String expiry_date_absolute)
    {
        this.expiry_date_absolute = expiry_date_absolute;
    }

    public String getIs_challenge ()
    {
        return is_challenge;
    }

    public void setIs_challenge (String is_challenge)
    {
        this.is_challenge = is_challenge;
    }

    public String getPoints ()
    {
        return points;
    }

    public void setPoints (String points)
    {
        this.points = points;
    }

    public String getTiming ()
    {
        return timing;
    }

    public void setTiming (String timing)
    {
        this.timing = timing;
    }

    public String getImage_content_width ()
    {
        return image_content_width;
    }

    public void setImage_content_width (String image_content_width)
    {
        this.image_content_width = image_content_width;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getHas_unallotted_vouchers ()
    {
        return has_unallotted_vouchers;
    }

    public void setHas_unallotted_vouchers (String has_unallotted_vouchers)
    {
        this.has_unallotted_vouchers = has_unallotted_vouchers;
    }

    public String getPound_value_text ()
    {
        return pound_value_text;
    }

    public void setPound_value_text (String pound_value_text)
    {
        this.pound_value_text = pound_value_text;
    }

    public String getHighlights ()
    {
        return highlights;
    }

    public void setHighlights (String highlights)
    {
        this.highlights = highlights;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getGifting_enabled ()
    {
        return gifting_enabled;
    }

    public void setGifting_enabled (String gifting_enabled)
    {
        this.gifting_enabled = gifting_enabled;
    }

    public String getPoints_for_gifting ()
    {
        return points_for_gifting;
    }

    public void setPoints_for_gifting (String points_for_gifting)
    {
        this.points_for_gifting = points_for_gifting;
    }

    public String getHas_in_app_purchase ()
    {
        return has_in_app_purchase;
    }

    public void setHas_in_app_purchase (String has_in_app_purchase)
    {
        this.has_in_app_purchase = has_in_app_purchase;
    }


    public Bitmap getLoadedImage() {
        return loadedImage;
    }

    public void setLoadedImage(Bitmap loadedImage) {
        this.loadedImage = loadedImage;
    }

    public boolean getHasImageLoaded() {
        return hasImageLoaded;
    }

    public void setHasImageLoaded(boolean hasImageLoaded) {
        this.hasImageLoaded = hasImageLoaded;
    }

    @Override
    public String toString()
    {
        return getId();
    }

    @Override
    public int compareTo(RewardItem o) {
        //Show newest items at the top
        if (Integer.parseInt(this.id) < Integer.parseInt(o.getId())){
            return 1;
        } else if (Integer.parseInt(this.id) > Integer.parseInt(o.getId())){
            return -1;
        }
        return 0;
    }
}