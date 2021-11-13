package edu.tntech.csc2310.fa2021;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Course
{
    String subject;
    String description;
    String title;
    String[] prereq;
    String number;
    String term;
    int credits;

    public Course(String subject, String number, String catalogYear) throws IOException
    {
        Document doc = Jsoup.connect("https://ttuss1.tntech.edu/PROD/bwckctlg.p_disp_course_detail?cat_term_in=" + catalogYear + "&subj_code_in=" + subject + "CSC&crse_numb_in=" + number).get();
        this.subject = subject;
        this.number = number;
        term = catalogYear;

        String newstring = doc.select(".ntdefault").text();
        description = newstring.split("Lab Hours Levels", 2)[0];
        String newstring2 = doc.select(".nttitle").text();
        title = newstring2;
        String[] newstring3 = newstring.split("Course or Test: ", 0);
        prereq = new String[newstring3.length-1];

        for(int i = newstring3.length-1; i >= 1; i--){
            prereq[i - 1] = (newstring3[i].split(" Minimum", 0)[0]);
        }
        for(int i = 0; i < prereq.length; i++){
            System.out.println(prereq[i]);
        }
        String integer = newstring.split(" OR ",0)[1].split(" Credit Hours ",0)[0].split("\\.",0)[0];
        credits = Integer.parseInt(integer);
        System.out.println(integer);
    }


    public String getSubject(){
        return subject;
    }
    public String getNumber(){
        return number;
    }
    public String getDescription(){
        return description;
    }
    public String getTitle(){
        return title;
    }
    public int getCredits(){
        return credits;
    }
    public String[] getPrereq(){
        return prereq;
    }

    public static void main(String[] args) throws IOException
    {
        CourseCatalog Stuff = new CourseCatalog("CSC", "202180");
        Stuff.getCourse("1300");
    }
}