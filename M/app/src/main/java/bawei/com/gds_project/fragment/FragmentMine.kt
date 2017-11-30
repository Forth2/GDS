package bawei.com.gds_project.fragment

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.ContentResolver
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.acticity.SettingActivity
import com.facebook.drawee.view.SimpleDraweeView
import android.provider.MediaStore
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.widget.Toast
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


/**
 *  1.类的用途
 *  2.@author棒棒糖：赵姗杉
 *  3.@date2017/11/27  16：46
 */
class FragmentMine :Fragment() ,View.OnClickListener {

    private val localTempImgDir = "localTempImgDir"
    private val localTempImgFileName = "localTempImgFileName"
    private var filePath: String? = null// 图片的URL
    private val IMAGE_UNSPECIFIED = "image/*"
    private val PHOTO_RESOULT = 3// 结果
    private var urii: Uri? = null
    lateinit var picPath:String
    lateinit var photo : Bitmap
    lateinit var mine_setting : ImageView
    lateinit var mine_fresco : SimpleDraweeView
    lateinit var mine_cache : TextView
    lateinit var mine_look : TextView
    lateinit var mine_message : TextView
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = View.inflate(context, R.layout.fragment_mine, null)
        initId(view)
        return view
    }

    private fun initId(view: View) {
        mine_setting = view.findViewById<ImageView>(R.id.mine_setting)
        mine_fresco=view.findViewById<SimpleDraweeView>(R.id.mine_fresco)
        mine_cache=view.findViewById<TextView>(R.id.mine_cache)
        mine_look=view.findViewById<TextView>(R.id.mine_look)
        mine_message=view.findViewById<TextView>(R.id.mine_message)
        mine_setting.setOnClickListener(this)
        mine_fresco.setOnClickListener(this)
        mine_cache.setOnClickListener(this)
        mine_look.setOnClickListener(this)
        mine_message.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
      when(p0?.id){
          R.id.mine_setting ->{
            var intent=Intent(activity,SettingActivity::class.java)
              startActivity(intent)
          }
          R.id.mine_fresco ->{
              //创建数据
              val items = arrayOf("从相册选择图片", "打开相机")
              var alertDialogBuilder = AlertDialog.Builder(activity)
              alertDialogBuilder.setIcon(R.mipmap.icon_setting).setTitle("提示")
                      .setItems(items, DialogInterface.OnClickListener {
                          dialogInterface, i ->
                            when(i){
                                0 ->{
                                    Log.e("xxx","相册")
                                    //打开相册
                                    openPic()
                                }
                                1 ->{
                                    Log.e("xxx","相机")
                                    openCamera()
                                }
                            }
              })
              //展示弹框
              alertDialogBuilder.create().show()
          }
          R.id.mine_look ->{

          }
          R.id.mine_message ->{

          }
          R.id.mine_cache ->{

          }
      }
    }
    private fun openCamera() {
            Log.d("DDD", "getPhotofromxiangji执行了>>>>>>>>");
        // 先验证手机是否有sdcard
     var status : String  = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            try {
               var dir: File =File(Environment.getExternalStorageDirectory().toString()+ "/" + localTempImgDir);
                if (!dir.exists())
                    dir.mkdirs();
                var intent :Intent= Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                var f:File = File(dir, localTempImgFileName);// localTempImgDir和localTempImageFileName是自己定义的名字
                var u:Uri = Uri.fromFile(f);
                intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(intent, 2);
            } catch (e : ActivityNotFoundException) {
                Toast.makeText(activity, "没有找到储存目录", Toast.LENGTH_LONG)
                        .show();
            }
        } else {
            Toast.makeText(activity, "没有储存卡", Toast.LENGTH_LONG)
                    .show();
        }
    }
    private fun openPic() {
        //隐示意图激活
        val intent = Intent(Intent.ACTION_PICK, null)
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
        startActivityForResult(intent, 11)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("DDD", "正在执行onActivityResult()方法");
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                11 -> {
                    var selectedImage = data?.data
                    var filePathColumns = arrayOf(MediaStore.Images.Media.DATA)
                    var c = activity.getContentResolver().query(selectedImage,
                            filePathColumns, null, null, null)
                    c.moveToFirst()
                    val columnIndex = c.getColumnIndex(filePathColumns[0])
                    val imagePath = c.getString(columnIndex)
                    showImage(imagePath)
                    c.close()
                }
                PHOTO_RESOULT ->
                     {
                    var extras: Bundle = data!!.extras;
                    if (extras != null) {
                        var photo: Bitmap = extras.getParcelable("data");
                        var stream: ByteArrayOutputStream = ByteArrayOutputStream();
                        photo.compress(Bitmap.CompressFormat.PNG, 100, stream);//
                        //   (0-100)压缩文件
                        mine_fresco.setImageBitmap(photo); // 把图片显示在ImageView控件上
                    }
                }

                2 -> {
                    val f = File(Environment.getExternalStorageDirectory().toString()
                            + "/" + localTempImgDir + "/" + localTempImgFileName)
                    try {
                        val u = Uri.parse(android.provider.MediaStore.Images.Media
                                .insertImage(activity.getContentResolver(),
                                        f.absolutePath, null, null))
                        startPhotoZoom(u)
                        //  buqianqie(u);
                    } catch (e: Exception) {
                        // TODO Auto-generated catch block
                        e.printStackTrace()
                    }

                }
            }
        }
    }

    /** 剪切图片  */
    fun startPhotoZoom(uri: Uri) {
        Log.d("DDD", "正在执行startPhotoZoom()方法")
        val intent = Intent("com.android.camera.action.CROP")
        urii = uri
        filePath = getUrlFromUri(this, uri)
        intent.setDataAndType(uri, IMAGE_UNSPECIFIED)
        intent.putExtra("crop", "true")
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1)
        intent.putExtra("aspectY", 1)
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 64)
        intent.putExtra("outputY", 64)
        intent.putExtra("return-data", true)
        startActivityForResult(intent, PHOTO_RESOULT)
    }
    /** 根据uri获取文件的路径URL */
    private fun getUrlFromUri(fragmentMine: FragmentMine, uri: Uri): String? {
        Log.d("DDD", "正在执行getUrlFromUri()方法")
        if (null == uri)
            return null
        var scheme = uri.scheme
        var data: String? = null
         if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
              var cursor:Cursor = context.getContentResolver().query(uri,
                    arrayOf( MediaStore.Images.ImageColumns.DATA ), null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    var index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

//展示相册的图片
    private fun showImage(imagePath: String?) {
        val bm = BitmapFactory.decodeFile(imagePath)
        mine_fresco.setImageBitmap(bm)

    }


}