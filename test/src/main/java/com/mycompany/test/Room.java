package com.mycompany.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Room{
    private static final String User="root";//to send it as a parameter to data base
    private static final String Password="";//~~~
    private static final String Url="jdbc:mysql://localhost:3306/rooms";//to get local host
    private static Connection connection;//to connect data base
    private static Statement statement;//to execute queries
    private static String query;//to do what i want
    private static ResultSet result;
    public static void addRoom(int id,String roomType,String roomDescription,int roomServiceb,String serviceType,String serviceDescription,int numOfbeds,int numOftvs,int safeb,int fridgeb,int wifib,double price,int busyb) throws SQLException{
        connection=DriverManager.getConnection(Url,User,Password);
        statement=connection.createStatement();
        query="insert into room values('"+id+"','"+roomType+"','"+roomDescription+"','"+roomServiceb+"','"+serviceType+"','"+serviceDescription+"','"+numOfbeds+"','"+numOftvs+"','"+safeb+"','"+fridgeb+"','"+wifib+"','"+price+"','"+busyb+"')";
        statement.execute(query);
    }
    /*public static void updateRoom(int id){
      ------------->desouqy  
    }*/
    public static void deleteRoom(int id) throws SQLException{
        connection=DriverManager.getConnection(Url,User,Password);
        statement = connection.createStatement();
        query="delete from room where id="+id;
        statement.execute(query);
    }
    public static void showData() throws SQLException{
        connection=DriverManager.getConnection(Url, User, Password);
        statement = connection.createStatement();
        result = statement.executeQuery("select * from room");
        while (result.next()) {
            System.out.println("Room Id-> " + result.getInt("id"));
            System.out.println("Room Type-> " + result.getString("roomType"));
            System.out.println("Room Description-> " + result.getString("roomDescription"));
            String roomService=(result.getInt("roomService")==1)?"Room service exists":"Doesnt Exist";
            System.out.println("Room Service-> " + roomService);
            System.out.println("Service Type-> " + result.getString("serviceType"));
            System.out.println("Service Description-> " + result.getString("serviceDescription"));
            System.out.println("Number Of Beds-> " + result.getInt("numOfbeds"));
            System.out.println("Number Of T.Vs-> " + result.getInt("noumOftvs"));
            String safe=(result.getInt("safe(b)")==1)?"Safe exists":"Doesnt Exist";
            System.out.println("Safe-> " + safe);
            String fridge=(result.getInt("fridge(b)")==1)?"fridge exists":"Doesnt Exist";
            System.out.println("Fridge-> " + fridge);
            String wifi=(result.getInt("wifi")==1)?"Free Wifi":"No wifi";
            System.out.println("Price per night-> " + result.getDouble("price"));
            String busy=(result.getInt("busy")==1)?"The Room Is Available":"The Room Is Not Available";
            System.out.println(busy);
            System.out.println("*******************************");
        }
    }
}

















//    private static ArrayList<Room> Rooms=new ArrayList<>();
//    private int roomId;//هنميز بها الغرفه 
//    private String roomType;//بنحدد كام واحد فى الغرفه
//    private boolean busy;//->Customer معتمده على انه فى عميل ولا ل
//    private String serviceName;//The room wil be vip or normal or what?
//    private boolean wifi;//there wifi or not
//    private int NumberOfBeds;//number of beds
//    private boolean cupbord;//there is cupbord or not
//    private boolean fridge;//there is fridge or not
//    private boolean roomService;//for example house keeping
//    private int numOfTvs;//number of televisisons
//    private String meals;//the meals for the room
//    private double price;//the price of the room 
//    private int numberOfdays;
//    public Room(){
//        //default for all of them esepecially busy it will be false
//    }
//    public Room(int roomId,String roomType,boolean wifi,String serviceName,int NumberOfBeds,boolean cupbord,boolean fridge,boolean roomService,int numOfTvs,int meals,double price){
//        this.roomId=roomId;//assign id for room
//        this.roomType=roomType;//assign room type for room
//        this.wifi=wifi;//assign wifi for room
//        this.serviceName=serviceName;//assign service name for the room
//        this.NumberOfBeds=NumberOfBeds;//assign number of beds in a room
//        this.cupbord=cupbord;//if there cupbord in the room or not
//        this.fridge=fridge;//if there fridge in the room or not
//        this.roomService=roomService;//if there room service for the room or not like house keeping
//        this.numOfTvs=numOfTvs;//number of televisions
//        this.price=price;//the price of the room
//    }
//    public void setId(int roomId){
//        this.roomId=roomId;//set id for the room and will treat it as index in array list
//    }
//    public int getId(){
//        return  this.roomId;//return the room id
//    }
//    public void setRoomType(String roomType){
//        this.roomType=roomType;//set type for the room
//    }
//    public String getRoomType(){
//        return  this.roomType;//return the room type
//    }
//    public boolean getBusy(){
//        return this.busy;//when we do assign for customer it will be true
//    }
//    public void setWifi(boolean wifi){
//        this.wifi=wifi;//assign wifi for the room
//    }
//    public boolean getWifi(){
//        return this.wifi;//get the wifi for the room it will return boolean type
//    }
//    public void setServiceName(String serviceName){
//        this.serviceName=serviceName;//assign the service name for the room
//    }
//    public String getServiceName(){
//        return this.serviceName;//get the service name for the room
//    }
//    public void setNumberofBeds(int NumberOfBeds){
//        this.NumberOfBeds=NumberOfBeds;//will assign number of beds for the room
//    }
//    public int getNumberOfBeds(){
//        return this.NumberOfBeds;//return number of beds for the room
//    }
//    public void setCupbord(boolean cupbord){
//        this.cupbord=cupbord;//assign the cupbord for the room if there cupbord it will be true else it will be false
//    }
//    public boolean getCupbord(){
//        return this.cupbord;//return boolean type for cupbord in the room the same condition as above
//    }
//    public void setFridge(boolean fridge){
//        this.fridge=fridge;//assign the fridge for the room if there fridge it will be true else it will be false
//    }
//    public boolean getFridge(){
//        return this.fridge;//return boolean type for fridge in the room the same condition as above
//    }
//    public void setPrice(double price){
//        this.price=price;
//    }
//    public void setRoomservice(boolean roomService){
//        this.roomService=roomService;//assign the Room for the room if there Room it will be true else it will be false
//    }
//    public void setnumberOfTvs(int numOfTvs){
//        this.numOfTvs=numOfTvs;
//    }
//    public int getnumOftvs(){
//        return this.numOfTvs;
//    }
//    public void setMeals(int choice){
//        if(choice==1)
//        {
//            this.meals="1 meal free for breakfast";
//        }
//        else if(choice==2)
//        {
//            this.meals="2 meals free for breakfast and lunch";
//        }
//        else if(choice==3){
//            this.meals="3 free meals for breakfast,lunch,dinner";
//        }
//        else{
//            this.meals="open buffeh along the day";
//        }
//    }
//    public String getMeals(){
//        return this.meals;
//    }
//    public boolean getRoomservice(){
//        return this.roomService;//return boolean type for Room service in the room the same condition as above
//    }
//    public double getPrice(){
//        return this.price;
//    }
//    public static void Add(int Id,String Type,boolean wifi,String Name,int Beds,boolean cupbord,boolean fridge,boolean roomService,int numofTvs,int meals,double price) throws SQLException{
//        connection=DriverManager.getConnection(add, user, pass);
//    }
//    
//    public static void delete(int id){
//       for(int i=0;i<Rooms.size();i++){
//           if(Rooms.get(i).getId()==id){
//               Rooms.remove(i);
//               break;
//           }
//       }
//    }
//    
//    public static void update(int id) {//id will be costant for the room we cant change it
//        System.out.print("Choose what do you want to change:\n");
//    }
//
//    public static void Show_All_Rooms(){//print all of the Rooms
//        for(int i=0;i<Rooms.size();i++){
//            System.out.print("Room id->"+Rooms.get(i).getId()+"\n");
//            System.out.print("Room Type->"+Rooms.get(i).getRoomType()+"\n");
//            String wifi=(Rooms.get(i).getWifi())?"Free Wifi":"No Wifi";
//            System.out.print("Room wifi->"+wifi+"\n");
//            System.out.print("Room Service->"+Rooms.get(i).getServiceName()+"\n");
//            System.out.print("Number of beds in the Room->"+Rooms.get(i).getNumberOfBeds()+"\n");
//            String cupbord=(Rooms.get(i).getCupbord())?"There is Cupbord":"No cupbord in the room";
//            System.out.print("Room Cupbord->"+cupbord+"\n");
//            String fridge=(Rooms.get(i).getFridge())?"There is fridge":"No fridge in the room";
//            System.out.print("Room fridge->"+fridge+"\n");
//            String service=(Rooms.get(i).getRoomservice())?"There is service":"No service in the room";
//            System.out.print("Room service->"+service+"\n");
//            System.out.print("Room Tvs->"+Rooms.get(i).getnumOftvs()+"\n");
//            System.out.print("Room meals->"+Rooms.get(i).getMeals()+"\n");
//            System.out.print("Room price->"+Rooms.get(i).getPrice()+"$ per night\n");
//            System.out.println("*********************************************");
//        }
//    }