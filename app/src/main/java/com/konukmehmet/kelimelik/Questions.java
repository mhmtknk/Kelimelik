package com.konukmehmet.kelimelik;

public class Questions {
public String mQuestion[]={
        "What's the name of the animal",
        "What is this",
        "It is for rain",
        "The most important things",
        "A part of the body"," "
};

    public int imageArray[] = { R.mipmap.bunny, R.mipmap.wallet,R.mipmap.umbrella, R.mipmap.time,R.mipmap.finger,R.mipmap.finger};

    private String mChoices[][] ={
            {"BUN","NY","LACK","LOW"},
            {"CEM","WAL","LET","ATES"},
            {"UM","BREL","LA","AM"},
            {"MES","TI","MA","ME"},
            {"FIN","FINN","GAR","GER"},
            {" "," "," "," "}
    };
    private String mCorrectAnswer[] = {"BUNNY","WALLET","UMBRELLA","TIME","FINGER",""};

    public String getQuestion(int a){
        return mQuestion[a];
    }
    public int getPicture(int a){ return imageArray[a]; }
    public String getChoice1(int a){
        return mChoices[a][0];
    }
    public String getChoice2(int a){ return mChoices[a][1]; }
    public String getChoice3(int a){
        return mChoices[a][2];
    }
    public String getChoice4(int a){
        return mChoices[a][3];
    }
    public String getCorrectAnswer(int a){
        return mCorrectAnswer[a];
    }
}
