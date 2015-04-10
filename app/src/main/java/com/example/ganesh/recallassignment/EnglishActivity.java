package com.example.ganesh.recallassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Ganesh on 2015-04-09.
 */
public class EnglishActivity extends Activity{


    ArrayList<String> model1 = new ArrayList<String>();
    String modelselected="";
    String model;
   @Override
    protected void onCreate(Bundle icic) {
        super.onCreate(icic);
       setContentView(R.layout.activity_english);
       final Intent result = new Intent(this, Results.class);
      final Spinner dropdownmodel = (Spinner) findViewById(R.id.model);
       Button Searchb1 = (Button) findViewById(R.id.Search);
        InputStream inputStream = getResources().openRawResource(
                R.raw.recall2);

       Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder db;


        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(inputStream);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        doc.getDocumentElement().normalize();
        NodeList Sectionelement  = doc.getElementsByTagName("Section");
        int sectionlength = Sectionelement.getLength();

        for (int a = 1; a < sectionlength; a++) {
           NodeList informationElements = doc.getElementsByTagName("Field");

            final int length = informationElements.getLength();

            for (int i = 0; i < length; i++) {
                Element node = (Element) informationElements.item(i);

                NamedNodeMap attributes = node.getAttributes();
                int numAttrs = attributes.getLength();
                for (int p = 0; p < numAttrs; p++) {
                    Attr attr = (Attr) attributes.item(p);
                    String attrName = attr.getNodeName();
                    String attrValue = attr.getNodeValue();
                     if (attrValue.equals("MAKENAMENM1")) {

                        Element eElement = (Element) node;

                        model = eElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                        model1.add(model);
                        ArrayList<String> unique = removeDuplicates(model1);
                         System.out.println("unique="+unique);
                        ArrayAdapter<String> langAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unique);

                        dropdownmodel.setAdapter(langAdapter);


                    }



                }

            }
        }
      Searchb1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

               modelselected= dropdownmodel.getSelectedItem().toString();
                System.out.println("modelselected="+modelselected);
                result.putExtra("model",modelselected);

               startActivity(result);



            }
        });


    }

    public static ArrayList<String> removeDuplicates(ArrayList<String> models) {

        // Store unique items in result.
        ArrayList<String> result = new ArrayList<>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : models) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }
}
