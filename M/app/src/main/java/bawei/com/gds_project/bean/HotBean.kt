package bawei.com.gds_project.bean

/**
 * Created by dell-pc on 2017/11/28.
 */

class HotBean {


    var count: Int = 0
    var total: Int = 0
    var nextPageUrl: Any? = null
    var itemList: List<ItemListBean>? = null

    constructor(count: Int, total: Int, nextPageUrl: Any?, itemList: List<ItemListBean>?) {
        this.count = count
        this.total = total
        this.nextPageUrl = nextPageUrl
        this.itemList = itemList
    }



    class ItemListBean {


        var type: String? = null
        var data: DataBean? = null
        var tag: Any? = null
        var id: Int = 0

        class DataBean {


            var dataType: String? = null
            var id: Int = 0
            var title: String? = null
            var slogan: String? = null
            var description: String? = null
            var provider: ProviderBean? = null
            var category: String? = null
            var author: Any? = null
            var cover: CoverBean? = null
            var playUrl: String? = null
            var thumbPlayUrl: String? = null
            var duration: Int = 0
            var webUrl: Any? = null
            var releaseTime: Long = 0
            var library: String? = null
            var consumption: ConsumptionBean? = null
            var campaign: Any? = null
            var waterMarks: Any? = null
            var adTrack: Any? = null
            var type: String? = null
            var titlePgc: Any? = null
            var descriptionPgc: Any? = null
            var remark: Any? = null
            var idx: Int = 0
            var shareAdTrack: Any? = null
            var favoriteAdTrack: Any? = null
            var webAdTrack: Any? = null
            var date: Long = 0
            var promotion: Any? = null
            var label: Any? = null
            var descriptionEditor: String? = null
            var isCollected: Boolean = false
            var isPlayed: Boolean = false
            var lastViewTime: Any? = null
            var playlists: Any? = null
            var playInfo: List<PlayInfoBean>? = null
            var tags: List<TagsBean>? = null
            var labelList: List<*>? = null
            var subtitles: List<*>? = null

            class ProviderBean {


                var name: String? = null
                var alias: String? = null
                var icon: String? = null
            }

            class CoverBean {


                var feed: String? = null
                var detail: String? = null
                var blurred: String? = null
                var sharing: Any? = null
                var homepage: String? = null
            }

            class ConsumptionBean {


                var collectionCount: Int = 0
                var shareCount: Int = 0
                var replyCount: Int = 0
            }

            class PlayInfoBean {


                var height: Int = 0
                var width: Int = 0
                var name: String? = null
                var type: String? = null
                var url: String? = null
                var urlList: List<UrlListBean>? = null

                class UrlListBean {


                    var name: String? = null
                    var url: String? = null
                    var size: Int = 0
                }
            }

            class TagsBean {


                var id: Int = 0
                var name: String? = null
                var actionUrl: String? = null
                var adTrack: Any? = null
                var desc: Any? = null
                var bgPicture: String? = null
                var headerImage: String? = null
                var tagRecType: String? = null
            }
        }
    }
}
