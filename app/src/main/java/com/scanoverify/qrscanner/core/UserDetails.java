package com.scanoverify.qrscanner.core;


import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.scanoverify.qrscanner.util.Util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class UserDetails {

    private String id;

    public String getReward_point() {
        return reward_point;
    }

    public void setReward_point(String reward_point) {
        if(TextUtils.isEmpty(reward_point)== false)
        this.reward_point = new String(reward_point);
    }



    public String getPan_pic() {
        return pan_pic;
    }

    public void setPan_pic(String pan_pic) {
        if(TextUtils.isEmpty(pan_pic)== false)
        this.pan_pic = new String(pan_pic);
    }

    public String getAadhar_pic() {
        return aadhar_pic;
    }

    public void setAadhar_pic(String aadhar_pic) {
        if(TextUtils.isEmpty(aadhar_pic)== false)
        this.aadhar_pic =  new String(aadhar_pic);
    }

    public String getBank_pic() {
        return bank_pic;
    }

    public void setBank_pic(String bank_pic) {
        if(TextUtils.isEmpty(bank_pic)== false)
        this.bank_pic = new String(bank_pic);
    }

    public String getQr_pic() {
        return qr_pic;
    }

    public void setQr_pic(String qr_pic) {
        if(TextUtils.isEmpty(qr_pic)== false)
        this.qr_pic = new String(qr_pic);
    }

    @SerializedName("pan_pic")
    @Expose
    private String pan_pic;
    @SerializedName("aadhar_pic")
    @Expose
    private String aadhar_pic;
    @SerializedName("bank_pic")
    @Expose
    private String bank_pic;
    @SerializedName("qr_pic")
    @Expose
    private String qr_pic;



    private String reward_point;

    private String sid;
    private String type;
    private String sessionyear;
    private String admissionDate;
    private String name;
    private String fname;
    private String mname;
    private String gender;
    private String caste;
    private String dob;
    private String phone;
    private String contact;
    private String email;
    private String othercitydetails;
    private String state;
    private String city;
    private String details;
    private String pincode;
    private String address;
    private String courseid;
    private String degreeid;
    private String currentyear;
    private String result_session;
    private String result_courseid;
    private String password;
    private String imgname;
    private String rollno;
    private String courseyear;
    private String class1;
    private String board1;
    private String shortid;
    private String passingyear1;
    private String maxmarks1;
    private String obtmarks1;
    private String division1;
    private String remarks1;
    private String class2;
    private String board2;
    private String passingyear2;
    private String maxmarks2;
    private String obtmarks2;
    private String division2;
    private String remarks2;
    private String class3;
    private String board3;

    private String view;



    public static HashMap<String, UserDetails> getStudents_map() {
        return students_map;
    }

    public static void setStudents_map(HashMap<String, UserDetails> students_map) {
        UserDetails.students_map = students_map;
    }

    private String reg_code;




    public static HashMap<String,UserDetails> students_map =new HashMap<String,UserDetails>();

    public UserDetails(UserDetails UserDetails)
    {
        setSid(UserDetails.getSid());
        setName(UserDetails.getName());
        setRollno(UserDetails.getRollno());
        setCourseid(UserDetails.getCourseid());
        setCurrentyear(UserDetails.getCurrentyear());
        setEmail(UserDetails.getEmail());
        setPhone(UserDetails.getPhone());
        setAdmissionDate(UserDetails.getAdmissionDate());
        setGender(UserDetails.getGender());
        setFname(UserDetails.getFname());
        setMname(UserDetails.getMname());
        setDob(UserDetails.getDob());
        setCity(UserDetails.getCity());
        setState(UserDetails.getState());
        setAddress(UserDetails.getAddress());
        setSessionyear(UserDetails.getSessionyear());
        setCaste(UserDetails.getCaste());
        setPincode(UserDetails.getPincode());
        setImgname(UserDetails.getImgname());
        setReg_code(UserDetails.getReg_code());
        setReward_point(UserDetails.getReward_point());

        //setView(UserDetails.getView());

        setAadhar_pic(UserDetails.getAadhar_pic());
        setPan_pic(UserDetails.getPan_pic());
        setQr_pic(UserDetails.getQr_pic());
        setBank_pic(UserDetails.getBank_pic());


    }



    public static void add_students(UserDetails UserDetails)
    {
        String key = UserDetails.getName();
        UserDetails myProd = new UserDetails(UserDetails);
        students_map.put(key,myProd);
    }

    public static  UserDetails get_students_by_name(String name)
    {
        return students_map.get(name);
    }

    public static void remove_students()
    {

        students_map.clear();
        students_list.clear();

    }

    public static List<UserDetails> getStudents_list() {
        return students_list;
    }

    public static void setStudents_list(List<UserDetails> students_list) {
        UserDetails.students_list = students_list;
    }

    public static List<UserDetails> students_list = new ArrayList<UserDetails>();


        public static List<UserDetails> generate_and_get_students_list()
        {

            UserDetails UserDetails = null;

            int cat_id=0;
            students_list.clear();

            Iterator it = students_map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                UserDetails = (UserDetails) pair.getValue();
                int size =  students_list.size();

                students_list.add(size,UserDetails);
                UserDetails=null;
            }
            //Collections.sort(session_list);
            return UserDetails.getStudents_list();
        }




    public String getView() {
        return view;
    }

    public void setView(String fees) {
        if(Util.isEmpty(fees) == false)
            this.view = new String(view);

    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        if(Util.isEmpty(fees) == false)
            this.fees = new String(fees);

        this.fees = fees;
    }

    public static UserDetails getMsDesireUser() {
        return msDesireUser;
    }

    public static void setMsDesireUser(UserDetails msDesireUser) {
        UserDetails.msDesireUser = msDesireUser;
    }

    private String fees;



    public static UserDetails msDesireUser = new UserDetails();

    public static void setDesireUser(UserDetails UserDetails) {

        if(!TextUtils.isEmpty(UserDetails.reg_code))
            msDesireUser.reg_code = new String(UserDetails.reg_code);

        if(!TextUtils.isEmpty(UserDetails.id))
            msDesireUser.id = new String(UserDetails.id);

        if(!TextUtils.isEmpty(UserDetails.sid))
            msDesireUser.sid = new String(UserDetails.sid);

        if(!TextUtils.isEmpty(UserDetails.type))
            msDesireUser.type = new String(UserDetails.type);

        if(!TextUtils.isEmpty(UserDetails.sessionyear))
            msDesireUser.sessionyear = new String(UserDetails.sessionyear);


        if(!TextUtils.isEmpty(UserDetails.admissionDate))
            msDesireUser.admissionDate = new String(UserDetails.admissionDate);

        if(!TextUtils.isEmpty(UserDetails.name))
            msDesireUser.name = new String(UserDetails.name);

        if(!TextUtils.isEmpty(UserDetails.fname))
            msDesireUser.fname = new String(UserDetails.fname);

        if(!TextUtils.isEmpty(UserDetails.mname))
            msDesireUser.mname = new String(UserDetails.mname);

        if(!TextUtils.isEmpty(UserDetails.gender))
            msDesireUser.gender = new String(UserDetails.gender);

        if(!TextUtils.isEmpty(UserDetails.caste))
            msDesireUser.caste = new String(UserDetails.caste);

        if(!TextUtils.isEmpty(UserDetails.dob))
            msDesireUser.dob = new String(UserDetails.dob);

        if(!TextUtils.isEmpty(UserDetails.phone))
            msDesireUser.phone = new String(UserDetails.phone);


        if(!TextUtils.isEmpty(UserDetails.city))
            msDesireUser.city = new String(UserDetails.city);


        if(!TextUtils.isEmpty(UserDetails.contact))
            msDesireUser.contact = new String(UserDetails.contact);

        if(!TextUtils.isEmpty(UserDetails.email))
            msDesireUser.email = new String(UserDetails.email);

        if(!TextUtils.isEmpty(UserDetails.othercitydetails))
            msDesireUser.othercitydetails = new String(UserDetails.othercitydetails);




        if(!TextUtils.isEmpty(UserDetails.state))
            msDesireUser.state = new String(UserDetails.state);

        if(!TextUtils.isEmpty(UserDetails.details))
            msDesireUser.details = new String(UserDetails.details);

        if(!TextUtils.isEmpty(UserDetails.pincode))
            msDesireUser.pincode = new String(UserDetails.pincode);

        if(!TextUtils.isEmpty(UserDetails.address))
            msDesireUser.address = new String(UserDetails.address);

        if(!TextUtils.isEmpty(UserDetails.courseid))
            msDesireUser.courseid = new String(UserDetails.courseid);

        if(!TextUtils.isEmpty(UserDetails.degreeid))
            msDesireUser.degreeid = new String(UserDetails.degreeid);

        if(!TextUtils.isEmpty(UserDetails.currentyear))
            msDesireUser.currentyear = new String(UserDetails.currentyear);

        if(!TextUtils.isEmpty(UserDetails.result_session))
            msDesireUser.result_session = new String(UserDetails.result_session);

        if(!TextUtils.isEmpty(UserDetails.result_courseid))
            msDesireUser.result_courseid = new String(UserDetails.result_courseid);

        if(!TextUtils.isEmpty(UserDetails.password))
            msDesireUser.password = new String(UserDetails.password);

        if(!TextUtils.isEmpty(UserDetails.imgname))
            msDesireUser.imgname = new String(UserDetails.imgname);

         if(!TextUtils.isEmpty(UserDetails.rollno))
            msDesireUser.rollno = new String(UserDetails.rollno);

        if(!TextUtils.isEmpty(UserDetails.courseyear))
            msDesireUser.courseyear = new String(UserDetails.courseyear);

        if(!TextUtils.isEmpty(UserDetails.class1))
            msDesireUser.class1 = new String(UserDetails.class1);

        if(!TextUtils.isEmpty(UserDetails.board1))
            msDesireUser.board1 = new String(UserDetails.board1);

        if(!TextUtils.isEmpty(UserDetails.shortid))
            msDesireUser.shortid = new String(UserDetails.shortid);

        if(!TextUtils.isEmpty(UserDetails.passingyear1))
            msDesireUser.passingyear1 = new String(UserDetails.passingyear1);


        if(!TextUtils.isEmpty(UserDetails.passingyear1))
            msDesireUser.maxmarks1 = new String(UserDetails.maxmarks1);


        if(!TextUtils.isEmpty(UserDetails.obtmarks1))
            msDesireUser.obtmarks1 = new String(UserDetails.obtmarks1);


        if(!TextUtils.isEmpty(UserDetails.division1))
            msDesireUser.division1 = new String(UserDetails.division1);


        if(!TextUtils.isEmpty(UserDetails.remarks1))
            msDesireUser.remarks1 = new String(UserDetails.remarks1);

        if(!TextUtils.isEmpty(UserDetails.class2))
            msDesireUser.class2 = new String(UserDetails.class2);

        if(!TextUtils.isEmpty(UserDetails.board2))
            msDesireUser.board2 = new String(UserDetails.board2);

        if(!TextUtils.isEmpty(UserDetails.passingyear2))
            msDesireUser.passingyear2 = new String(UserDetails.passingyear2);



        if(!TextUtils.isEmpty(UserDetails.maxmarks2))
            msDesireUser.maxmarks2 = new String(UserDetails.maxmarks2);



        if(!TextUtils.isEmpty(UserDetails.obtmarks2))
            msDesireUser.obtmarks2 = new String(UserDetails.obtmarks2);


        if(!TextUtils.isEmpty(UserDetails.obtmarks2))
            msDesireUser.obtmarks2 = new String(UserDetails.obtmarks2);


        if(!TextUtils.isEmpty(UserDetails.division2))
            msDesireUser.division2 = new String(UserDetails.division2);


            if(!TextUtils.isEmpty(UserDetails.remarks2))
            msDesireUser.remarks2 = new String(UserDetails.remarks2);


        if(!TextUtils.isEmpty(UserDetails.class3))
            msDesireUser.class3 = new String(UserDetails.class3);



        if(!TextUtils.isEmpty(UserDetails.board3))
            msDesireUser.board3 = new String(UserDetails.board3);


        if(!TextUtils.isEmpty(UserDetails.reward_point))
            msDesireUser.reward_point = new String(UserDetails.reward_point);



    }
    public static UserDetails getDesireUser() {
        return  msDesireUser;
    }


    public String getReg_code() {
        return reg_code;
    }

    public void setReg_code(String reg_code) {
        if(!TextUtils.isEmpty(reg_code))
            this.reg_code = new String(reg_code);
          }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(!TextUtils.isEmpty(id))
            this.id = new String(id);
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        if(!TextUtils.isEmpty(sid))
        this.sid = new String(sid);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(!TextUtils.isEmpty(type))
            this.type = new String(type);
    }

    public String getSessionyear() {
        return sessionyear;
    }

    public void setSessionyear(String sessionyear) {
        if(!TextUtils.isEmpty(sessionyear))
            this.sessionyear = new String(sessionyear);
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        if(!TextUtils.isEmpty(admissionDate))
            this.admissionDate = new String(admissionDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!TextUtils.isEmpty(name))
            this.name = new String(name);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        if(!TextUtils.isEmpty(fname))
            this.fname = new String(fname);
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        if(!TextUtils.isEmpty(mname))
            this.mname = new String(mname);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(!TextUtils.isEmpty(gender))
            this.gender = new String(gender);
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        if(!TextUtils.isEmpty(caste))
            this.caste = new String(caste);
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        if(!TextUtils.isEmpty(dob))
            this.dob = new String(dob);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(!TextUtils.isEmpty(phone))
            this.phone = new String(phone);
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        if(!TextUtils.isEmpty(contact))
            this.contact = new String(contact);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!TextUtils.isEmpty(email))
            this.email = new String(email);
    }

    public String getOthercitydetails() {
        return othercitydetails;
    }

    public void setOthercitydetails(String othercitydetails) {
        if(!TextUtils.isEmpty(othercitydetails))
            this.othercitydetails = new String(othercitydetails);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(!TextUtils.isEmpty(city))
            this.city = new String(city);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(!TextUtils.isEmpty(state))
            this.state = new String(state);
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        if(!TextUtils.isEmpty(details))
            this.details = new String(details);
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        if(!TextUtils.isEmpty(pincode))
            this.pincode = new String(pincode);
}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(!TextUtils.isEmpty(address))
            this.address = new String(address);
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        if(!TextUtils.isEmpty(courseid))
            this.courseid = new String(courseid);
    }

    public String getDegreeid() {
        return degreeid;
    }

    public void setDegreeid(String degreeid) {
        if(!TextUtils.isEmpty(degreeid))
            this.degreeid = new String(degreeid);
    }

    public String getCurrentyear() {
        return currentyear;
    }

    public void setCurrentyear(String currentyear) {
        if(!TextUtils.isEmpty(currentyear))
            this.currentyear = new String(currentyear);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(!TextUtils.isEmpty(password))
            this.password = new String(password);
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        if(!TextUtils.isEmpty(imgname))
            this.imgname = new String(imgname);
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        if(!TextUtils.isEmpty(rollno))
            this.rollno = new String(rollno);
    }

    public String getCourseyear() {
        return courseyear;
    }

    public void setCourseyear(String courseyear) {
        if(!TextUtils.isEmpty(courseyear))
            this.courseyear = new String(courseyear);
    }


    public String getResult_session() {
        return  result_session ;
    }

    public void setResult_session(String result_session ) {
        if(!TextUtils.isEmpty(sid))
        this. result_session  =  result_session ;
    }

    public String getResult_courseid() {
        return  result_courseid;
    }

    public void setResult_courseid(String result_courseid) {
        if(!TextUtils.isEmpty(sid))
        this. result_courseid =  result_courseid;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {

        if(!TextUtils.isEmpty(class1))
            this.class1 = class1;
    }

    public String getBoard1() {
        return board1;
    }

    public void setBoard1(String board1) {
        if(!TextUtils.isEmpty(board1))
            this.board1 = new String(board1);
    }

    public String getShortid() {
        return shortid;
    }

    public void setShortid(String shortid) {
        if(!TextUtils.isEmpty(shortid))
            this.shortid = new String(shortid);
    }

    public String getPassingyear1() {
        return passingyear1;
    }

    public void setPassingyear1(String passingyear1) {

        if(!TextUtils.isEmpty(passingyear1))
            this.passingyear1 = new String(passingyear1);
    }

    public String getMaxmarks1() {
        return maxmarks1;
    }

    public void setMaxmarks1(String maxmarks1) {

        if(!TextUtils.isEmpty(maxmarks1))
            this.maxmarks1 = new String(maxmarks1);
    }

    public String getObtmarks1() {
        return obtmarks1;
    }

    public void setObtmarks1(String obtmarks1) {

        if(!TextUtils.isEmpty(sid))
            this.obtmarks1 = obtmarks1;
    }

    public String getDivision1() {
        return division1;
    }

    public void setDivision1(String division1) {
        if(!TextUtils.isEmpty(division1))
            this.division1 = new String(division1);
}

    public String getRemarks1() {
        return remarks1;
    }

    public void setRemarks1(String remarks1) {

        if(!TextUtils.isEmpty(remarks1))
            this.remarks1 = new String(remarks1);
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {

        if(!TextUtils.isEmpty(class2))
            this.class2 = new String(class2);
    }

    public String getBoard2() {
        return board2;
    }

    public void setBoard2(String board2) {

        if(!TextUtils.isEmpty(board2))
            this.board2 = new String(board2);
    }

    public String getPassingyear2() {
        return passingyear2;
    }

    public void setPassingyear2(String passingyear2)
    {
        if(!TextUtils.isEmpty(passingyear2))
            this.passingyear2 = new String(passingyear2);
    }

    public String getMaxmarks2() {
        return maxmarks2;
    }

    public void setMaxmarks2(String maxmarks2) {
        if(!TextUtils.isEmpty(maxmarks2))
            this.maxmarks2 = new String(maxmarks2);
    }

    public String getObtmarks2() {
        return obtmarks2;
    }

    public void setObtmarks2(String obtmarks2) {
        if(!TextUtils.isEmpty(obtmarks2))
            this.obtmarks2 = new String(obtmarks2);
    }

    public String getDivision2() {
        return division2;
    }

    public void setDivision2(String division2) {

        if(!TextUtils.isEmpty(division2))
            this.division2 = new String(division2);
    }

    public String getRemarks2() {
        return remarks2;
    }

    public void setRemarks2(String remarks2) {
        if(!TextUtils.isEmpty(remarks2))
            this.remarks2 = new String(remarks2);
    }

    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {

        if(!TextUtils.isEmpty(class3))
            this.class3 = new String(class3);
    }

    public String getBoard3() {
        return board3;
    }

    public void setBoard3(String board3) {
        if(!TextUtils.isEmpty(board3))
            this.board3 = new String(board3);
    }

    public String getPassingyear3() {
        return passingyear3;
    }

    public void setPassingyear3(String passingyear3) {
        if(!TextUtils.isEmpty(sid))
        this.passingyear3 = new String(passingyear3);
    }

    public String getMaxmarks3() {
        return maxmarks3;
    }

    public void setMaxmarks3(String maxmarks3) {
        if(!TextUtils.isEmpty(maxmarks3))
        this.maxmarks3 = new String(maxmarks3);
    }

    public String getObtmarks3() {
        return obtmarks3;
    }

    public void setObtmarks3(String obtmarks3) {
        if(!TextUtils.isEmpty(obtmarks3))
        this.obtmarks3 = new String(obtmarks3);
    }

    public String getDivision3() {
        return division3;
    }

    public void setDivision3(String division3)
    {
        if(!TextUtils.isEmpty(division3))
        this.division3 = new String(division3);
    }

    public String getRemarks3() {
        return remarks3;
    }

    public void setRemarks3(String remarks3) {
        if(!TextUtils.isEmpty(remarks3))
        this.remarks3 = new String(remarks3);
    }

    public String getNoofpaper() {
        return noofpaper;
    }

    public void setNoofpaper(String noofpaper) {

        if(!TextUtils.isEmpty(noofpaper))
        this.noofpaper = new String(noofpaper);
    }

    public String getPeryearcoursefees() {
        return peryearcoursefees;
    }

    public void setPeryearcoursefees(String peryearcoursefees) {
        if(!TextUtils.isEmpty(peryearcoursefees))
        this.peryearcoursefees = new String(peryearcoursefees);
    }

    public String getCoursefees() {
        return coursefees;
    }

    public void setCoursefees(String coursefees) {

        if(!TextUtils.isEmpty(coursefees))
        this.coursefees = new String(coursefees);
    }

    public String getCoursedetails() {
        return coursedetails;
    }

    public void setCoursedetails(String coursedetails) {

        if(!TextUtils.isEmpty(coursedetails))
        this.coursedetails = new String(coursedetails);
    }

    public String getYearsessionstart() {
        return yearsessionstart;
    }

    public void setYearsessionstart(String yearsessionstart) {

        if(!TextUtils.isEmpty(yearsessionstart))
        this.yearsessionstart = new String(yearsessionstart);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status)
    {
        if(!TextUtils.isEmpty(status))
        this.status = new String(status);
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {

        if(!TextUtils.isEmpty(dates))
        this.dates = new String(dates);
    }

    private String passingyear3;

    private String maxmarks3;

    private String obtmarks3;

    private String division3;

    private String remarks3;

    private String noofpaper;

    private String peryearcoursefees;

    private String coursefees;

    private String coursedetails;

    private String yearsessionstart;

    private String status;

    private String dates;

    public UserDetails()
    {

    }

    public UserDetails(String id, String sid, String type, String sessionyear, String admissionDate, String name, String fname,
                       String mname, String gender, String caste, String dob, String phone, String contact, String email,
                       String othercitydetails, String city, String state, String details, String pincode, String address, String courseid,
                       String degreeid, String currentyear, String result_session, String result_courseid, String password, String imgname, String rollno, String courseyear,
                       String class1, String board1, String shortid, String passingyear1, String maxmarks1, String obtmarks1,
                       String division1, String remarks1, String class2, String board2, String passingyear2, String maxmarks2,
                       String obtmarks2, String division2, String remarks2, String class3, String board3, String passingyear3,
                       String maxmarks3, String obtmarks3, String division3, String remarks3, String noofpaper,
                       String peryearcoursefees, String coursefees, String coursedetails, String yearsessionstart,
                       String status, String dates, String reg_code) {
        this.id = id;
        this.sid = sid;
        this.type = type;
        this.sessionyear = sessionyear;
        this.admissionDate = admissionDate;
        this.name = name;
        this.fname = fname;
        this.mname = mname;
        this.gender = gender;
        this.caste = caste;
        this.dob = dob;
        this.phone = phone;
        this.contact = contact;
        this.email = email;
        this.city = city;
        this.othercitydetails = othercitydetails;
        this.state = state;
        this.details = details;
        this.pincode = pincode;
        this.address = address;
        this.courseid = courseid;
        this.degreeid = degreeid;
        this.result_session =result_session;
        this.currentyear = currentyear;
        this. result_courseid =  result_courseid;
        this.password = password;
        this.imgname = imgname;
        this.rollno = rollno;
        this.courseyear = courseyear;
        this.class1 = class1;
        this.board1 = board1;
        this.shortid = shortid;
        this.passingyear1 = passingyear1;
        this.maxmarks1 = maxmarks1;
        this.obtmarks1 = obtmarks1;
        this.division1 = division1;
        this.remarks1 = remarks1;
        this.class2 = class2;
        this.board2 = board2;
        this.passingyear2 = passingyear2;
        this.maxmarks2 = maxmarks2;
        this.obtmarks2 = obtmarks2;
        this.division2 = division2;
        this.remarks2 = remarks2;
        this.class3 = class3;
        this.board3 = board3;
        this.passingyear3 = passingyear3;
        this.maxmarks3 = maxmarks3;
        this.obtmarks3 = obtmarks3;
        this.division3 = division3;
        this.remarks3 = remarks3;
        this.noofpaper = noofpaper;
        this.peryearcoursefees = peryearcoursefees;
        this.coursefees = coursefees;
        this.coursedetails = coursedetails;
        this.yearsessionstart = yearsessionstart;
        this.status = status;
        this.dates = dates;
        this.reg_code = reg_code;
    }



}
