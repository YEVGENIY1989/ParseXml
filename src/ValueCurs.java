public class ValueCurs {

    private String ID;
    private String mCode;
    private int mNominalVal;
    private String mNameValRus;
    private String mValue;
    private String mDateFileXml;

    public ValueCurs(String id, String code, int nominalVal, String nameValRus, String value){

        ID = id;
        mCode = code;
        mNominalVal = nominalVal;
        mNameValRus = nameValRus;
        mValue = value;

    }

    public void setDateFileXml(String dateFileXml) {
        mDateFileXml = dateFileXml;
    }

    public String getDateFileXml(){
        return mDateFileXml;
    }

    public String getID() {
        return ID;
    }

    public String getCode() {
        return mCode;
    }

    public int getNominalVal() {
        return mNominalVal;
    }

    public String getNameValRus() {
        return mNameValRus;
    }

    public String getValue() {
        return mValue;
    }
}
