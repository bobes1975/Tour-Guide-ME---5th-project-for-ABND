package com.example.android.project05_nd_tourguideme;

public class Place {

    /**
     * Constant value that represents no image was provided for category
     */
    private static final int NO_IMAGE_PROVIDED = -1;


    // category
    private String mCategoryPlace;

    //name
    private String mNamePlace;

    //info
    private String mInfoPlace;

    // phone
    private String mPhonePlace;

    //web page
    private String mWebPlace;

    // email
    private String mEmailPlace;

    // address
    private String mAddressPlace;

    // quote
    private String mQuotePlace;

    // Id for proper picture
    private int mImagePlace = NO_IMAGE_PROVIDED;

    /**
     * Create new Composer Object
     *
     * @param categoryPlace   is name of category
     * @param namePlace       is name of place
     * @param infoPlace       is info text about proper place
     * @param phonePlace      is contact phone number
     * @param webPlace        is web address of place
     * @param addressPlace    is address of the place
     * @param imageResourceId is ID for proper image
     */
    public Place(String categoryPlace, String namePlace, String infoPlace, String phonePlace, String webPlace, String emailPlace, String addressPlace, String quotePlace, int imageResourceId) {
        mCategoryPlace = categoryPlace;
        mNamePlace = namePlace;
        mInfoPlace = infoPlace;
        mPhonePlace = phonePlace;
        mWebPlace = webPlace;
        mEmailPlace = emailPlace;
        mAddressPlace = addressPlace;
        mQuotePlace = quotePlace;
        mImagePlace = imageResourceId;
    }

    public Place(String namePlace) {
        mNamePlace = namePlace;
    }

    //get category of place
    public String getCategoryPlace() {
        return mCategoryPlace;
    }

    //get name of place
    public String getNamePlace() {
        return mNamePlace;
    }

    // get Info of place
    public String getInfoPlace() {
        return mInfoPlace;
    }

    // get phone number
    public String getPhonePlace() {
        return mPhonePlace;
    }

    // get web page address
    public String getWebPlace() {
        return mWebPlace;
    }

    // get email address
    public String getEmailPlace() {
        return mEmailPlace;
    }

    // get address of place
    public String getAddressPlace() {
        return mAddressPlace;
    }

    // get address of place
    public String getQuotePlace() {
        return mQuotePlace;
    }

    // get image ID
    public Integer getImageResourceId() {
        return mImagePlace;
    }

    // returns whether ot not there is an image for category
    public boolean hasImage() {
        return mImagePlace != NO_IMAGE_PROVIDED;
    }
}
