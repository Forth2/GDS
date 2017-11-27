package bawei.com.gds_project.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View
import java.util.*

/**
 * Created by dell-pc on 2017/11/23.
 */
class ClockView : View {



    //View默认最小宽度
    val DEFAULT_MIN_WIDTH : Int = 200
    //外圆边框宽度
    val DEFAULT_BORDER_WIDTH : Float = 6f
    //长刻度线
    val DEFAULT_LONG_DEGREE_LENGTH : Float= 0f
    //短刻度线
    val DEFAULT_SHORT_DEGREE_LENGTH : Float= 0f
    //指针反向超过圆点的长度
    val DEFAULT_POINT_BACK_LENGTH = 40f

    //秒针长度
    var secondPointerLength: Float = 0.toFloat()
    //分针长度
    var minutePointerLength: Float = 0.toFloat()
    //时针长度
    var hourPointerLength: Float = 0.toFloat()


    public constructor(context: Context) : super(context) {
        init()
    }

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    public constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        timeThread.start()
    }

    /**
     * 计算时针、分针、秒针的长度
     */
    private fun reset() {
        val r = 140f
        secondPointerLength = r * 0.8f
        minutePointerLength = r * 0.6f
        hourPointerLength = r * 0.5f
    }

    /**
     * 当布局为wrap_content时 设置默认长宽
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measure(widthMeasureSpec),measure(heightMeasureSpec))
    }

    /**
     * 重写measure方法
     */
    fun measure(origin : Int): Int{

        var result : Int = DEFAULT_MIN_WIDTH
        val specMode = MeasureSpec.getMode(origin)
        val specSize = MeasureSpec.getSize(origin)
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize
        }else{
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize)
            }
        }

        return result
    }

    /**
     * 重写onDraw进行绘制
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        reset()
        /**
         * 画外圆
         */
        val borderWidth : Float = DEFAULT_BORDER_WIDTH  //外圆边框宽度
        val r : Float = 120F //半径
        val paintCircle = Paint() //画笔
        paintCircle.color = Color.BLACK
        paintCircle.style = Paint.Style.STROKE
        paintCircle.isAntiAlias = true
        paintCircle.strokeWidth = borderWidth
        canvas?.drawCircle((width / 2).toFloat(), (height/2).toFloat(),r,paintCircle)

        /**
         * 画刻度线
         */
        var degreeLength : Float = 0f
        val paintDegree =Paint()
        paintDegree.color=Color.BLACK
        paintDegree.isAntiAlias=true
        for (i in 0..60){
            if (i % 5 == 0) {
                paintDegree.strokeWidth = 6f
                degreeLength = DEFAULT_LONG_DEGREE_LENGTH
            } else {
                paintDegree.strokeWidth = 3f
                degreeLength = DEFAULT_SHORT_DEGREE_LENGTH
            }
            canvas?.drawLine((width / 2).toFloat(), Math.abs(height / 2 - r), (width / 2).toFloat(), Math.abs(height / 2 - r) + degreeLength, paintDegree)
            canvas?.rotate((360 / 60).toFloat(), (width / 2).toFloat(), (height / 2).toFloat())
        }

        //刻度数字
        val degressNumberSize = 30
        canvas?.translate((width / 2).toFloat(), (height / 2).toFloat())
        val paintDegreeNumber = Paint()
        paintDegreeNumber.color = Color.BLACK
        paintDegreeNumber.textAlign = Paint.Align.CENTER
        paintDegreeNumber.textSize = degressNumberSize.toFloat()
        paintDegreeNumber.isFakeBoldText = true
        for (i in 0..11) {
            val temp = calculatePoint(((i + 1) * 30).toFloat(), r - DEFAULT_LONG_DEGREE_LENGTH - (degressNumberSize / 2).toFloat() - 15f)
            canvas?.drawText((i + 1).toString() + "", temp[2], temp[3] + degressNumberSize / 2 - 6, paintDegreeNumber)
        }

        //画指针
        val paintHour = Paint()
        paintHour.color = Color.BLACK
        paintHour.isAntiAlias = true
        paintHour.strokeWidth = 11f
        val paintMinute = Paint()
        paintMinute.color = Color.BLACK
        paintMinute.isAntiAlias = true
        paintMinute.strokeWidth = 8f
        val paintSecond = Paint()
        paintSecond.color = Color.BLACK
        paintSecond.isAntiAlias = true
        paintSecond.strokeWidth = 5f
        val now = Calendar.getInstance()
        val hourPoints = calculatePoint(now.get(Calendar.HOUR_OF_DAY) % 12 / 12f * 360, hourPointerLength)
        canvas?.drawLine(hourPoints[0], hourPoints[1], hourPoints[2], hourPoints[3], paintHour)
        val minutePoints = calculatePoint(now.get(Calendar.MINUTE) / 60f * 360, minutePointerLength)
        canvas?.drawLine(minutePoints[0], minutePoints[1], minutePoints[2], minutePoints[3], paintMinute)
        val secondPoints = calculatePoint(now.get(Calendar.SECOND) / 60f * 360, secondPointerLength)
        canvas?.drawLine(secondPoints[0], secondPoints[1], secondPoints[2], secondPoints[3], paintSecond)

        //画圆心
        val paintCenter = Paint()
        paintCenter.color = Color.WHITE
        canvas?.drawCircle(0f, 0f, 3f, paintCenter)

    }

    /**
     * 根据角度和长度计算线段的起点和终点的坐标
     * @param angle
     * @param length
     * @return
     */
    private fun calculatePoint(angle: Float, length: Float): FloatArray {
        val points = FloatArray(4)
        if (angle <= 90f) {
            points[0] = -Math.sin(angle * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[1] = Math.cos(angle * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[2] = Math.sin(angle * Math.PI / 180).toFloat() * length
            points[3] = -Math.cos(angle * Math.PI / 180).toFloat() * length
        } else if (angle <= 180f) {
            points[0] = -Math.cos((angle - 90) * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[1] = -Math.sin((angle - 90) * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[2] = Math.cos((angle - 90) * Math.PI / 180).toFloat() * length
            points[3] = Math.sin((angle - 90) * Math.PI / 180).toFloat() * length
        } else if (angle <= 270f) {
            points[0] = Math.sin((angle - 180) * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[1] = -Math.cos((angle - 180) * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[2] = -Math.sin((angle - 180) * Math.PI / 180).toFloat() * length
            points[3] = Math.cos((angle - 180) * Math.PI / 180).toFloat() * length
        } else if (angle <= 360f) {
            points[0] = Math.cos((angle - 270) * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[1] = Math.sin((angle - 270) * Math.PI / 180).toFloat() * DEFAULT_POINT_BACK_LENGTH
            points[2] = -Math.cos((angle - 270) * Math.PI / 180).toFloat() * length
            points[3] = -Math.sin((angle - 270) * Math.PI / 180).toFloat() * length
        }
        return points
    }

    private val timeThread = object : Thread() {
        override fun run() {
            try {
                while (true) {
                    updateHandler.sendEmptyMessage(0)
                    Thread.sleep(1000)
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
    }

    private val updateHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            invalidate() //重新绘制
        }
    }

}