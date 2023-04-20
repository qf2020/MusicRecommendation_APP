package cjk.design.music.activity.ui.personal_information;

import static android.provider.MediaStore.EXTRA_OUTPUT;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.bumptech.glide.Glide;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cjk.design.music.R;
import cjk.design.music.databinding.ActivityMyInfoBinding;
import cjk.design.music.databinding.ActivityPlayListBinding;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;

/**
 *
 * @description 个人信息修改界面
 */

public class PersonInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int TAKE_PHOTO = 1;
    private static final int FROM_ALBUMS = 2;
    private static final int EDIT_NAME = 3;
    private static final int EDIT_HIGH = 4;
    private static final int EDIT_WEIGH = 5;

    private UserInformationBean userInformation;

    private ItemGroupView igId;
    private ItemNameEdit igName;
    private ItemGroupView igGender;
    private ItemGroupView igRegion;
    private ItemGroupView igBirthday;
    private ItemEditGroup igHigh;
    private ItemEditGroup igWeigh;
    private ItemNameEdit igHospital;
    private ItemNameEdit igOffice;
    private ItemEditGroup igYear;
    //组合控件
    private EditText EditName;
    private EditText EditHigh;
    private EditText EditWeigh;
    private TextView EditBirthday;
    private TextView EditSex;
    private TextView EditHome;
    private EditText EditHospital;
    private EditText EditOffice;
    private EditText EditYear;
    private LinearLayout llPortrait; //背景布局
    private byte[] portrait;
    private ArrayList<String> optionsItemsGender = new ArrayList<>(); //性别选项
    private ArrayList<ProvinceBeanUtils> options1Items = new ArrayList<>(); //省市选项
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private OptionsPickerView pvOptions;

    private ImageView riPortrati; //圆形头像

    private Uri imageUri;  //拍照功能的地址
    private PopupWindow popupWindow; //选择框
    private String imagePath;  //从相册中选的地址
    private byte[] imgData;
    private PhotoUtils photoUtils = new PhotoUtils(); //有关拍照的方法
    private String tx;
    private String tx2;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date;
    Bitmap bitmap;
    private File takePhotoFile;
    private int who;
    private int userRole;
    private ActivityMyInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        who = intent.getIntExtra("Id", 0);
        userRole = intent.getIntExtra("userRole", 0);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

                initOptionData();
                igName = (ItemNameEdit) findViewById(R.id.person_info_name_ig);
                igGender = (ItemGroupView) findViewById(R.id.person_info_gender_ig);
                igRegion = (ItemGroupView) findViewById(R.id.person_info_region_ig);
                igBirthday = (ItemGroupView) findViewById(R.id.person_info_birthday_ig);
                //igHigh = (ItemEditGroup) findViewById(R.id.person_info_high_ig);
               // igWeigh = (ItemEditGroup) findViewById(R.id.person_info_weigh_ig);
                llPortrait = (LinearLayout) findViewById(R.id.person_info_portrait_ll);
                riPortrati = findViewById(R.id.person_info_portrait_ri);
                EditName = (EditText) igName.findViewById(R.id.item_group_edit_content_et);
//                EditHigh = (EditText) igHigh.findViewById(R.id.item_group_edit_content_et);
//                EditWeigh = (EditText) igWeigh.findViewById(R.id.item_group_edit_content_et);
                EditBirthday = (TextView) igBirthday.findViewById(R.id.item_group_content_text);
                EditSex = (TextView) igGender.findViewById(R.id.item_group_content_text);
                EditHome = (TextView) igRegion.findViewById(R.id.item_group_content_text);

                //EditHigh = (EditText) findViewById(R.id.item_group_edit_content_et);
                //EditWeigh = (EditText) findViewById(R.id.item_group_edit_content_et);
                //igName.setOnClickListener(this);
                igGender.setOnClickListener(this);
                igRegion.setOnClickListener(this);
                igBirthday.setOnClickListener(this);
                llPortrait.setOnClickListener(this);
                //igHigh.setOnClickListener(this);
                //igWeigh.setOnClickListener(this);

                /**
                 *
                 * @description 设置点击保存的逻辑
                 */
        binding.personToolbar.setTitle("个人信息");
        setSupportActionBar(binding.personToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//                titleLayoutView.getTextViewForward().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
                        //loginUser.setHigh();
                /*loginUser.setName(EditName.getText().toString());
                loginUser.setWeigh(EditWeigh.getText().toString());
                loginUser.setHigh(EditHigh.getText().toString());
                loginUser.setRegion(tx2);
                loginUser.setGender(tx);*/
                        //loginUser.update();

//                        String patientName, patientSex, patientHome, patientBirthday, patientHigh1, patientWeigh1, patientAvatar;
//                        int patientHigh, patientWeigh;
//                        patientName = EditName.getText().toString();
//                        patientHome = EditHome.getText().toString();
//                        patientBirthday = EditBirthday.getText().toString();
//                        patientSex = EditSex.getText().toString();
//                        patientHigh1 = EditHigh.getText().toString();
//                        patientWeigh1 = EditWeigh.getText().toString();
//                        patientHigh = Integer.parseInt(patientHigh1);
//                        patientWeigh = Integer.parseInt(patientWeigh1);
                        //byte [] patientAvatarByte;
                        //patientAvatarByte = photoUtils.bitmapToByte(bitmap);
                        //patientAvatar =  new String(patientAvatarByte);
                        //System.out.println(Arrays.toString(patientAvatarByte));
                        //File file = uri2File(imageUri);



                       // File fileBuf = convertToBytes(inputStream_byte);

                        //File file = new File(imageUri.getPath());
                        //System.out.println(imageUri.getPath());、
//                        if (imagePath != null) {
                            //上传图片的地方
//                            View toastRoot2 = getLayoutInflater().inflate(R.layout.my_toast, null);
//                            Toast toast2 = new Toast(getApplicationContext());
//                            toast2.setView(toastRoot2);
//                            TextView tv2 = (TextView) toastRoot2.findViewById(R.id.TextViewInfo);
//                            tv2.setText("信息上传中，请耐心等待！");
//                            toast2.setDuration(Toast.LENGTH_SHORT);
//                            toast2.setGravity(Gravity.CENTER,0,0);
//                            toast2.show();
//                            System.out.println(imagePath);
//                            File file = new File(imagePath);
//                            System.out.println(file);


                            //patientAvatar = databaseUtils.updateFile(file);
                           // System.out.println(patientAvatar);


                           /* databaseUtils.updatePatient(patientInfoBean.getPatientInformationId(),
                                    patientName, patientSex, patientBirthday, patientHigh, patientWeigh,patientAvatar,patientHome,patientAvatarByte);*/
//                        }
//                        if(imageUri != null){
//                            另一种上传方式
//                            View toastRoot2 = getLayoutInflater().inflate(R.layout.my_toast, null);
//                            Toast toast2 = new Toast(getApplicationContext());
//                            toast2.setView(toastRoot2);
//                            TextView tv2 = (TextView) toastRoot2.findViewById(R.id.TextViewInfo);
//                            tv2.setText("信息上传中，请耐心等待！");
//                            toast2.setDuration(Toast.LENGTH_SHORT);
//                            toast2.setGravity(Gravity.CENTER,0,0);
//                            toast2.show();
//                            File file = new File(getFromMediaUri(getApplicationContext(), getContentResolver(), imageUri));
//                            System.out.println(file);
                            //patientAvatar = databaseUtils.updateFile(file);
                            //System.out.println(patientAvatar);
                           /*databaseUtils.updatePatient(patientInfoBean.getPatientInformationId(),
                                    patientName, patientSex, patientBirthday, patientHigh, patientWeigh,patientAvatar,patientHome,patientAvatarByte);*/

//                        }
//                        if(imagePath == null && imageUri == null){
                           /* System.out.println(imageUri);
                            String imgpath = imageUri.getPath();
                            System.out.println(imgpath);
                            File file = new File(imgpath);
                            System.out.println(file);


                            patientAvatar = databaseUtils.updateFile(file);*/
                            //System.out.println(patientAvatar);
                            /*databaseUtils.updatePatient(patientInfoBean.getPatientInformationId(),
                                    patientName, patientSex, patientBirthday, patientHigh, patientWeigh,null,patientHome,patientAvatarByte);*/
//                        }
//                        finish();
//                        View toastRoot = getLayoutInflater().inflate(R.layout.my_toast, null);
//                        Toast toast = new Toast(getApplicationContext());
//                        toast.setView(toastRoot);
//                        TextView tv = (TextView) toastRoot.findViewById(R.id.TextViewInfo);
//                        tv.setText("保存成功");
//                        toast.setDuration(Toast.LENGTH_SHORT);
//                        toast.show();

//                    }
//                });

                //initPatientInfo();
        initData(1);
    }

    private void initData(int userID){
        System.out.println("是否调用这个");
        HttpClient.getInformation(String.valueOf(userID),new HttpCallback<UserInformationBean>() {
            @Override
            public void onSuccess(UserInformationBean userInformationBean) {
                if (userInformationBean == null || userInformationBean.getRows() == null) {
                    onFail(null);
                    return;
                }
                userInformation = userInformationBean;
                binding.personInfoNameIg.getContentEdt().setText(userInformationBean.getRows().get(0).getUserName());
                binding.personInfoGenderIg.getContentEdt().setText(userInformationBean.getRows().get(0).getUserSex()==1?"男":"女");
                binding.personInfoRegionIg.getContentEdt().setText(userInformationBean.getRows().get(0).getUserAddress());
                binding.personInfoBirthdayIg.getContentEdt().setText(userInformationBean.getRows().get(0).getUserBirthday());
                Glide.with(getApplicationContext()).load(userInformationBean.getRows().get(0).getUserCover())
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .error(R.drawable.user_logo)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                        .into(riPortrati);
            }

            @Override
            public void onFail(Exception e) {
                System.out.println(e);
            }
        });
    }




    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    /**
     *
     * @description 对不同itemGroup设置点击事件
     *
     */
    @Override
    public void onClick(View v){
        switch (v.getId()){
            //点击修改地区逻辑
            case R.id.person_info_region_ig:
                CloseKeyBoard();
                pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        //选择了则显示并暂存loginUser，退出时在保存至数据库
                        String tx = options1Items.get(options1).getPickerViewText();
                        if(tx == "上海市" || tx == "天津市" || tx == "北京市" || tx == "重庆市" || tx == "香港特别行政区" || tx == "澳门特别行政区" ){
                            igRegion.getContentEdt().setText(tx);
                            //loginUser.setRegion(tx);
                        }
                        else {
                            tx2 = options1Items.get(options1).getPickerViewText()
                                    + options2Items.get(options1).get(options2);
                            igRegion.getContentEdt().setText(tx2);
                            //databaseUtils.updatePatient(patientInfoBean.getPatientInformationId(),null,null,null,0,0,tx2);


                        }
                    }
                }).setCancelColor(Color.GRAY).build();
                pvOptions.setPicker(options1Items, options2Items);//二级选择器
                pvOptions.show();
                break;

            //点击修改性别逻辑
            case R.id.person_info_gender_ig:
                //性别选择器
                CloseKeyBoard();
                pvOptions = new OptionsPickerBuilder(PersonInfoActivity.this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                        //选择了则显示并暂存loginUser，退出时在保存至数据库
                        tx = optionsItemsGender.get(options1);
                        igGender.getContentEdt().setText(tx);

                    }
                }).setCancelColor(Color.GRAY).build();
                pvOptions.setPicker(optionsItemsGender);
                pvOptions.show();
                break;

            //点击修改生日逻辑
            case R.id.person_info_birthday_ig:
                //时间选择器
                //修改打开的默认时间，如果选择过则是选择过的时间，否则是系统默认时间
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = Calendar.getInstance().getTime();
                String day = sdf.format(date);
                CloseKeyBoard();
                //if (loginUser.getBrithday() != null){
                    //try {
                        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                       //selectedDate.setTime(sdf.parse(loginUser.getBrithday()));
                   // }catch (ParseException e){
                       // e.printStackTrace();
                   // }
               // }
                //初始化picker并show
                TimePickerView pvTime = new TimePickerBuilder(PersonInfoActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        //选择了则显示并暂存loginUser，退出时在保存至数据库
                        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                        igBirthday.getContentEdt().setText(simpleDateFormat.format(date));
                        //loginUser.setBirthday(simpleDateFormat.format(date));
                    }
                }).setDate(selectedDate).setCancelColor(Color.GRAY).setRangDate(null,selectedDate).build();
                pvTime.show();
                break;
            //点击修改头像的逻辑
            case R.id.person_info_portrait_ll:
                //展示选择框，并设置选择框的监听器
                showPopupWindows();
                break;
            //点击修改名字的逻辑
           /* case R.id.person_info_name_ig:
                Intent intent1  = new Intent(PersonInfoActivity.this, EditNameActivity.class);
                startActivityForResult(intent1, EDIT_NAME);
                break;
            //点击修改身高的逻辑
            case R.id.person_info_high_ig:
                Intent intent2  = new Intent(PersonInfoActivity.this, EditHighActivity.class);
                startActivityForResult(intent2, EDIT_HIGH);
                break;
            //点击修改提供的逻辑
            case R.id.person_info_weigh_ig:
                Intent intent3  = new Intent(PersonInfoActivity.this, EditWeighActivity.class);
                startActivityForResult(intent3, EDIT_WEIGH);
                break;*/
            default:
                break;
        }
    }
    /**
     *
     * @description 处理各种回调事件函数
     *
     */
    public String getRealFilePath(final Context context, final Uri uri) {
        if (null == uri){
            return null;
        }

        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
        {
            data = uri.getPath();
        }
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri,
                    new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }
    String getFilePathFromContentUri(Uri selectedVideoUri, ContentResolver contentResolver) {
        String filePath;
        String[] filePathColumn = {MediaStore.MediaColumns.DATA};
        Cursor cursor = contentResolver.query(selectedVideoUri, filePathColumn, null, null, null);
        //也可用下面的方法拿到cursor
        //Cursor  cursor  =  this.context.managedQuery(selectedVideoUri,  filePathColumn,  null,  null,  null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        filePath = cursor.getString(columnIndex);
        cursor.close();
        return filePath;
    }



    public void setPortrait(byte[] portrait) {
        this.portrait = portrait;
    }
    //处理拍摄照片回调
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        switch (requestCode){
            //拍照得到图片
            case TAKE_PHOTO:
                if(resultCode == RESULT_OK) {
                    try {
                        //将拍摄的图片展示并更新数据库
                        bitmap = BitmapFactory.decodeStream((getContentResolver().openInputStream(imageUri)));

                        Glide.with(getApplicationContext()).load(bitmap)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .error(R.drawable.play_page_default_bg)
                                .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                                .into(riPortrati);

                        System.out.println(imageUri);

                        //String filePath = photoUtils.getImagePath(getApplicationContext(),imageUri, null);
                      //  System.out.println(filePath);
                       // File file = new File(filePath);
                      //  databaseUtils.updateFile(file);
                        setPortrait(photoUtils.bitmapToByte(bitmap));
                        } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                break;
            //从相册中选择图片
            case FROM_ALBUMS:
                if(resultCode == RESULT_OK){
                    if(Build.VERSION.SDK_INT >= 19) {
                        imagePath =  photoUtils.handleImageOnKitKat(this, data);
                        if(imageUri != null){
                            imageUri = null;
                        }
                    } else {
                        imagePath = photoUtils.handleImageBeforeKitKat(this, data);
                        if(imageUri != null){
                            imageUri = null;
                        }
                    }
                }
                if(imagePath != null){
                    //将拍摄的图片展示并更新数据库
                    System.out.println(imagePath);
                    bitmap = BitmapFactory.decodeFile(imagePath);
                    Glide.with(getApplicationContext()).load(bitmap)
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                            .error(R.drawable.play_page_default_bg)
                            .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                            .into(riPortrati);
                    //DatabaseUtils.uploadFile(new File(imagePath));
                    setPortrait(photoUtils.bitmapToByte(bitmap));

                    // DatabaseUtils databaseUtils = new DatabaseUtils();
                    //databaseUtils.uploadLogFile(photoUtils.bitmapToByte(bitmap));
                }else{
                    Log.d("picture","没有找到图片");
                }
                break;
            //如果是编辑名字，则修改展示
            /*case EDIT_NAME:
                if(resultCode == RESULT_OK){
                    igName.getContentEdt().setText(loginUser.getName());//数据库
                }
                break;
            case EDIT_HIGH:
                if(resultCode == RESULT_OK){
                    igHigh.getContentEdt().setText(loginUser.getHigh());//数据库
                }
                break;
            case EDIT_WEIGH:
                if(resultCode == RESULT_OK){
                    igWeigh.getContentEdt().setText(loginUser.getWeigh());//数据库
                }
                break;*/
            default:
                break;
        }
    }








    /**
     *
     * @description 初始化性别、地址和生日的数据
     */
    private void initOptionData(){
        //性别选择器数据
        optionsItemsGender.add(new String("男"));
        optionsItemsGender.add(new String("女"));

        //地址选择器数据
        String provinceData = readJsonFile("province.json");
        String cityData = readJsonFile("city.json");

        Gson gson = new Gson();

        options1Items = gson.fromJson(provinceData, new TypeToken<ArrayList<ProvinceBeanUtils>>(){}.getType());
        ArrayList<CityBeanUtils> cityBeanData = gson.fromJson(cityData, new TypeToken<ArrayList<CityBeanUtils>>(){}.getType());
        for(ProvinceBeanUtils provinceBeanUtils :options1Items){
            ArrayList<String> temp = new ArrayList<>();
            for (CityBeanUtils cityBean : cityBeanData){
                if(provinceBeanUtils.getProvince().equals(cityBean.getProvince())){
                    temp.add(cityBean.getName());
                }
            }
            options2Items.add(temp);
        }

    }
    public Bitmap getBitmap(String path) throws IOException {

        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200){
            InputStream inputStream = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }
        return null;
    }
    public byte[] GetUserHead(String urlpath) throws IOException {
        URL url = new URL(urlpath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // 设置请求方法为GET
        conn.setReadTimeout(5 * 1000); // 设置请求过时时间为5秒
        InputStream inputStream = conn.getInputStream(); // 通过输入流获得图片数据
        byte[] data = StreamTool.readInputStream(inputStream); // 获得图片的二进制数据
        return data;
    }




    /**
     * 从asset文件夹的json文件读取数据
     */
    private String readJsonFile(String file){
        StringBuilder newStringBuilder = new StringBuilder();
        try {
            InputStream inputStream = getResources().getAssets().open(file);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String jsonLine;
            while ((jsonLine = bufferedReader.readLine()) != null) {
                newStringBuilder.append(jsonLine);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data =  newStringBuilder.toString();
        return data;
    }
    private static String getFromMediaUri(Context context, ContentResolver resolver, Uri uri) {
        if (uri == null) {
            return null;
        }

        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            ParcelFileDescriptor pfd = resolver.openFileDescriptor(uri, "r");
            if (pfd == null) {
                return null;
            }
            FileDescriptor fd = pfd.getFileDescriptor();
            input = new FileInputStream(fd);

            String tempFilename = getTempFilename(context)+".jpg";
            output = new FileOutputStream(tempFilename);

            int read;
            byte[] bytes = new byte[4096];
            while ((read = input.read(bytes)) != -1) {
                output.write(bytes, 0, read);
            }

            return new File(tempFilename).getAbsolutePath();
        } catch (Exception ignored) {

            ignored.getStackTrace();
        } finally {
            closeSilently(input);
            closeSilently(output);
        }
        return null;
    }
    private static String getTempFilename(Context context) throws IOException {
        File outputDir = context.getCacheDir();
        File outputFile = File.createTempFile("image", "tmp", outputDir);
        return outputFile.getAbsolutePath();
    }
    public static void closeSilently(@Nullable Closeable c) {
        if (c == null){
            return;
        }
        try {
            c.close();
        } catch (Throwable t) {
            // Do nothing
        }
    }
    public void CloseKeyBoard() {
        EditName.clearFocus();
        /*EditOffice.clearFocus();
        EditHospital.clearFocus();
        EditWeigh.clearFocus();
        EditHigh.clearFocus();*/
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(EditName.getWindowToken(), 0);
        /*imm.hideSoftInputFromWindow(EditOffice.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(EditHospital.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(EditWeigh.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(EditHigh.getWindowToken(), 0);*/

    }

    // 监听点击屏幕上任何位置软键盘消失
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        CloseKeyBoard();
        return super.onTouchEvent(event);
    }

    /**
     *
     * @description 展示修改头像的选择框，并设置选择框的监听器
     *
     */
    private void showPopupWindows(){
        CloseKeyBoard();
        RelativeLayout layoutPhotoSelected = (RelativeLayout) getLayoutInflater().inflate(R.layout.photo_select_ppw,null);
        if(popupWindow==null){
            popupWindow = new PopupWindow(layoutPhotoSelected, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        }
        //显示popupwindows
        popupWindow.showAtLocation(layoutPhotoSelected, Gravity.CENTER, 0, 0);
        //设置监听器
        TextView takePhoto =  (TextView) layoutPhotoSelected.findViewById(R.id.photo_select_take_photo_text);
        TextView fromAlbums = (TextView)  layoutPhotoSelected.findViewById(R.id.photo_select_from_albums_text);
        LinearLayout cancel = (LinearLayout) layoutPhotoSelected.findViewById(R.id.photo_select_cancel_text);
        //拍照按钮监听
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(popupWindow != null && popupWindow.isShowing()) {
                    /*Date now = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
                    dateFormat.format( now );
                    String hehe = dateFormat.format( now );*/
                    imageUri = photoUtils.takePhotoUtil(PersonInfoActivity.this, "cjk.design.music.fileProvider", "filename.jpg");
                    if(imagePath!=null){
                        imagePath=null;
                    }
                    //takePhotoFile = photoUtils.takePhotoFile(PersonInfoActivity.this, "com.example.irehab.fileprovider", "filename.jpg");
                    //String patientAvatar;
                    //patientAvatar = databaseUtils.updateFile(takePhotoFile);
                    //System.out.println(patientAvatar);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra(EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, TAKE_PHOTO);
                    //去除选择框
                    popupWindow.dismiss();
                }
            }
        });
        //相册按钮监听
        fromAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //申请权限
                if(ContextCompat.checkSelfPermission(PersonInfoActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(PersonInfoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }else {
                    //打开相册
                    //imageUri = photoUtils.take_photo_util(PersonInfo.this, "com.example.personinfo.fileprovider", "output_image.jpg");
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, FROM_ALBUMS);
                }
                //去除选择框
                popupWindow.dismiss();
            }
        });
        //取消按钮监听
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //这边写修改信息代码:
                userInformation.getRows().get(0).setUserName(EditName.getText().toString());
                userInformation.getRows().get(0).setUserBirthday(EditBirthday.getText().toString());
                userInformation.getRows().get(0).setUserAddress(EditHome.getText().toString());
                userInformation.getRows().get(0).setUserSex(EditSex.getText().toString().equals("男")?1:0);
                //userInformation.getRows().get(0).setUserCover();

                HttpClient.changeInformation(userInformation.getRows().get(0),new HttpCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("修改成功");
                    }

                    @Override
                    public void onFail(Exception e) {
                        System.out.println(e);
                    }
                });
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
