package com.scanoverify.qrscanner.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.scanoverify.qrscanner.RegisterActivity;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Util {

    public final  static String TAG = "in.desirewebworld.desireclasses";
    public static String message="";
    public static int redirect_flag = 0;

    static String pdf = "http://drive.google.com/viewerng/viewer?embedded=true&url=" ;

    public static String convert_utf8(String str) throws UnsupportedEncodingException {
        String convert_str ="";
        convert_str =  new String(str.getBytes("UTF-16LE"), "UTF-8");
        return convert_str;
    }


    public static String get_current_date_YYYY_MM_DD()
    {
        Date date = new Date();
        return new SimpleDateFormat(Desire_Constants.SQL_DATE_FORMAT).format(date);
    }


    public static String get_mac_address() {
        String tmp ="";
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    tmp = Integer.toHexString(b & 0xFF);
                    if(tmp.length()==1)
                    {
                        tmp ="0"+tmp;
                    }

                    res1.append(tmp + ":");
                    tmp ="";
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }





    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!sourceFile.exists()) {
            return;
        }

        FileChannel source = null;
        FileChannel destination = null;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }
    }

    public static String getMimeType(String url)
    {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }

    public static String[] get_month_array(String month_value)
    {
        return month_value.split(",");
    }
    public static String get_month_name(String month_value)
    {
        String month_name= "";

        switch (month_value)
        {

            case "1":
            {
                month_name="Jan";
                break;
            }
            case "2":
            {
                month_name="Feb";
                break;
            }
            case "3":
            {
                month_name="Mar";
                break;
            }
            case "4":
            {
                month_name="Apr";
                break;
            }
            case "5":
            {
                month_name="May";
                break;
            }
            case "6":
            {
                month_name="Jun";
                break;
            }
            case "7":
            {
                month_name="Jul";
                break;
            }
            case "8":
            {
                month_name="Aug";
                break;
            }
            case "9":
            {
                month_name="Sep";
                break;
            }
            case "10":
            {
                month_name="Oct";
                break;
            }
            case "11":
            {
                month_name="Nov";
                break;
            }
            case "12":
            {
                month_name="Dec";
                break;
            }

        }
        return month_name;
    }

    public static String get_all_months(String month_value)
    {
        String all_months="";
        String months_arrya[] = get_month_array( month_value);
        for (String month : months_arrya)
        {
            if(all_months == "")
            {
                all_months =   get_month_name(month);
            }
            else
            {
                all_months =  all_months + " , " + get_month_name(month);
            }

        }
        return all_months;
    }


    public static String convert_string_to_init_cap(String str)
    {

        String result_str = new String();
        String others ="";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = str.trim();
        if (str.length() == 1) {
            return str.toUpperCase();
        }

        String letters[] = str.split(" ");
        for ( String word: letters
        ) {
            int len = word.length();
            if(len == 0)
            {
                continue;
            }
            char mychar = word.charAt(0);

            mychar = Character.toUpperCase(mychar);
            others = word.substring(1,len).toLowerCase();
            result_str += mychar + others + " ";
        }


        return result_str.trim();
    }


    public static String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }


    public static Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte= Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static String get_first_name(String name)
    {
        String first_str="";
        String letters[] = name.split(" ");
        for ( String word: letters )
        {
            first_str=word;
            break;
        }

        return first_str.trim();
    }

    public static String get_current_date()
    {

        Date dateobj = new Date();

        DateFormat df = new SimpleDateFormat(Desire_Constants.SQL_DATE_FORMAT);
        return df.format(dateobj);

    }
    public static String remove_string(String str, String key)
    {
        return str.replace(key, "");
    }

    public static String get_last_name(String name)
    {
        String last_str="";
        int i=0;
        int len = 0;
        String letters[] = name.split(" ");
        for ( String word: letters )

        {
            len = word.length();
            break;


        }
        last_str = name.substring(len,name.length());
        return last_str.trim();
    }


    public static  void show_error_alert(Activity activity, String msg, String error_code)
    {
        redirect_flag = 0;
        String str = "Error Code ("+ error_code + ") "+ msg;
        show_alert( str, "Error", activity);
    }



    public  static void show_alert(String msg, String title, Context context)
    {
        AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        builder.setMessage(msg) .setTitle(title);

        //Setting message manually and performing action on button click
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                if(redirect_flag == 1)
                                {
                                    redirect_flag = 0;
                                   // RegisterActivity.registrationActivity.show_login();
                                }
                            }
                        }
                );
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(title);
        alert.show();
    }

    public static String convert_html_to_string(String str)
    {
        if(isEmpty(str) == false)
        {
            return Html.fromHtml(str).toString();
        }
        return "";
    }

    public static  void show_sack(View view, String msg)
    {
        Snackbar.make(view,msg, Snackbar.LENGTH_LONG).show();
    }



    public static void delay( long miliseccond)
    {

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

            }
        }, miliseccond);
    }

    public static  void show_toast_for_waiting(Activity activity)
    {
        Toast.makeText(activity, "Please Wait ... ", Toast.LENGTH_SHORT).show();
    }

    public static  void show_msg(Activity activity, String msg)
    {
        DesireLog.Log(msg);

        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    public static  void show_error_msg(Activity activity, String msg, String error_code)
    {
        String str = "Error Code ("+ error_code + ") "+ msg;
        DesireLog.Log(str);
        Toast.makeText(activity, str, Toast.LENGTH_SHORT).show();
    }




    public static boolean validate_pass(Activity activity, String str)
    {

        if (!TextUtils.isEmpty(str))
        {

            if(str.length()< 6)
            {
                message = " Please provide correct password of min 6 length.";
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        else
        {
            message = " Please provide correct password.";
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public static boolean validate_pin(Activity activity, String str)
    {

        if (!TextUtils.isEmpty(str))
        {

            if(str.length()!= 4)
            {
                message = " Please provide correct mpin of length  4.";
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        else
        {
            message = " Please provide correct mpin.";
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public static  boolean match_pass(Activity activity, String str1, String str)
    {
        if (!str1.equals(str)) {
            message = " Your password not matched.";
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public static  boolean match_pin(Activity activity, String str1, String str)
    {
        if (!str1.equals(str)) {
            message = " Your mpin not matched.";
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public static boolean isEmpty(String str)
    {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }




    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyymmddhhmmss", Locale.getDefault());


    public static String getTempFilename(Context context) throws IOException {
        File outputDir = context.getCacheDir();
        File outputFile = File.createTempFile("image", "tmp", outputDir);
        return outputFile.getAbsolutePath();
    }



    public static File getCompressed(Context context, String path) throws IOException {
        if(context == null)
            throw new NullPointerException("Context must not be null.");

        File cacheDir = context.getExternalCacheDir();
        if(cacheDir == null)

            cacheDir = context.getCacheDir();
        String rootDir = cacheDir.getAbsolutePath() + "/ImageCompressor";
        File root = new File(rootDir);

        if(!root.exists())
            root.mkdirs();

        Bitmap bitmap = decodeImageFromFiles(path, /* your desired width*/300, /*your desired height*/ 300);

        File compressed = new File(root, SDF.format(new Date()) + ".jpg" /*Your desired format*/);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(compressed);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();

        return compressed;
    }



    public static Bitmap get_bitmap(String link)
    {
        Bitmap image = null;
        try {
            URL url = new URL(link);
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch(IOException e) {
            System.out.println(e);
        }
        return image;
    }

    public static  int compare_two_dates(String date1, String date2)
    {
        SimpleDateFormat
                formatter
                = new SimpleDateFormat(Desire_Constants.SQL_DATE_FORMAT);

        // Get the two dates to be compared
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = formatter.parse(date1);
            d2 = formatter.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

       return d1.compareTo(d2);
    }
    public static String get_new_date_after_added_date(String fromDate, int days)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(Desire_Constants.SQL_DATE_FORMAT);
        Date currentDate   = null;
        try {
            currentDate = formatter.parse(fromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        c.add(Calendar.DATE, days); //same with c.add(Calendar.DAY_OF_MONTH, 1);

      /*  // manipulate date
        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.HOUR, 1);
        c.add(Calendar.MINUTE, 1);
        c.add(Calendar.SECOND, 1);*/

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();

        return new SimpleDateFormat(Desire_Constants.SQL_DATE_FORMAT).format(currentDatePlusOne);
    }



    public static Bitmap decodeImageFromFiles(String path, int width, int height) {
        BitmapFactory.Options scaleOptions = new BitmapFactory.Options();
        scaleOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, scaleOptions);
        int scale = 1;
        while (scaleOptions.outWidth / scale / 2 >= width
                && scaleOptions.outHeight / scale / 2 >= height) {
            scale *= 2;
        }

        BitmapFactory.Options outOptions = new BitmapFactory.Options();
        outOptions.inSampleSize = scale;
        return BitmapFactory.decodeFile(path, outOptions);
    }




    public static String get_notification_short_msg(String str) {
        str = convert_html_to_string(str);
        int len =50;
        if(str.length()< len)
        {
            return str;
        }
        String last_str = str.substring(0,len);
        len = last_str.lastIndexOf(" ", len);
          last_str = str.substring(0,len);
          last_str += " ... ";
        return last_str.trim();
    }
}
