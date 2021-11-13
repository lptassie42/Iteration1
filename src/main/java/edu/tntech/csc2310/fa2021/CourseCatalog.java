package edu.tntech.csc2310.fa2021;
import java.io.IOException;
import java.util.ArrayList;

public class CourseCatalog
{
    String subject;
    String term;

    private ArrayList<Course> db;

    public CourseCatalog(String subject, String catalogYear) throws IOException
    {
        this.subject = subject;
        this.term = catalogYear;
    }

    public Course getCourse(String number) throws IOException{
        Course newcourse = new Course(subject,number,term);
        return newcourse;
    }

    public String getSubject(){
        return subject;
    }

    public String getCatalogYear() {
        return term;
    }
}
