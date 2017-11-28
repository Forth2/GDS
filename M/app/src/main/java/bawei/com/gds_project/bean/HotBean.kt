package bawei.com.gds_project.bean

/**
 * Created by dell-pc on 2017/11/28.
 */
class HotBean {

data class Hotbean(
		val itemList: List<Item>,
		val count: Int, //35
		val total: Int, //0
		val nextPageUrl: Any //null
)

data class Item(
		val type: String, //video
		val data: Data,
		val tag: Any, //null
		val id: Int //0
)

data class Data(
		val dataType: String, //VideoBeanForClient
		val id: Int, //19512
		val title: String, //飙车预警丨怼天怼地怼空气
		val slogan: String, //安全性爱公益广告「AIDS Smutley」
		val description: String, //倡导安全性爱公益广告「AIDS Smutley」开车开的又污又大胆。猫有九条命，而你只有一条，就算再怎么泰迪附身，也不能这么随性乱搞！这些艾滋病防治宣传片，大家看懂了？From XYZ Studios
		val provider: Provider,
		val category: String, //动画
		val author: Any, //null
		val cover: Cover,
		val playUrl: String, //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=19512&editionType=default&source=qcloud
		val thumbPlayUrl: String, //http://baobab.kaiyanapp.com/api/v1/playUrl/1510992910381_88d4e0d2.mp4?vid=19512&source=qcloud
		val duration: Int, //140
		val webUrl: Any, //null
		val releaseTime: Long, //1511658001000
		val library: String, //DAILY
		val playInfo: List<PlayInfo>,
		val consumption: Consumption,
		val campaign: Any, //null
		val waterMarks: Any, //null
		val adTrack: Any, //null
		val tags: List<Tag>,
		val type: String, //NORMAL
		val titlePgc: Any, //null
		val descriptionPgc: Any, //null
		val remark: Any, //null
		val idx: Int, //0
		val shareAdTrack: Any, //null
		val favoriteAdTrack: Any, //null
		val webAdTrack: Any, //null
		val date: Long, //1511658001000
		val promotion: Any, //null
		val label: Any, //null
		val labelList: List<Any>,
		val descriptionEditor: String, //倡导安全性爱公益广告「AIDS Smutley」开车开的又污又大胆。猫有九条命，而你只有一条，就算再怎么泰迪附身，也不能这么随性乱搞！这些艾滋病防治宣传片，大家看懂了？From XYZ Studios
		val collected: Boolean, //false
		val played: Boolean, //false
		val subtitles: List<Any>,
		val lastViewTime: Any, //null
		val playlists: Any //null
)

data class Provider(
		val name: String, //Vimeo
		val alias: String, //vimeo
		val icon: String //http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png
)

data class Consumption(
		val collectionCount: Int, //1918
		val shareCount: Int, //3051
		val replyCount: Int //69
)

data class Cover(
		val feed: String, //http://img.kaiyanapp.com/f068325b77aa8fd0ae6e62433182e4ac.jpeg?imageMogr2/quality/60/format/jpg
		val detail: String, //http://img.kaiyanapp.com/f068325b77aa8fd0ae6e62433182e4ac.jpeg?imageMogr2/quality/60/format/jpg
		val blurred: String, //http://img.kaiyanapp.com/2e88fa63312c15789abca15c34fabbf2.jpeg?imageMogr2/quality/60/format/jpg
		val sharing: Any, //null
		val homepage: String //http://img.kaiyanapp.com/f068325b77aa8fd0ae6e62433182e4ac.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
)

data class Tag(
		val id: Int, //172
		val name: String, //什么鬼
		val actionUrl: String, //eyepetizer://tag/172/?title=%E4%BB%80%E4%B9%88%E9%AC%BC
		val adTrack: Any, //null
		val desc: Any, //null
		val bgPicture: String, //http://img.kaiyanapp.com/e6b5568e865b26f3f84270e613955e59.jpeg?imageMogr2/quality/60/format/jpg
		val headerImage: String, //http://img.kaiyanapp.com/e6b5568e865b26f3f84270e613955e59.jpeg?imageMogr2/quality/60/format/jpg
		val tagRecType: String //NORMAL
)

data class PlayInfo(
		val height: Int, //480
		val width: Int, //854
		val urlList: List<Url>,
		val name: String, //标清
		val type: String, //normal
		val url: String //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=19512&editionType=normal&source=qcloud
)

data class Url(
		val name: String, //qcloud
		val url: String, //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=19512&editionType=normal&source=qcloud
		val size: Int //12952514
)
}