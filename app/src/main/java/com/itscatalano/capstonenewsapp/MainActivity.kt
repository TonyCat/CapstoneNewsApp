package com.itscatalano.capstonenewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.children
import com.itscatalano.capstonenewsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val article = arrayListOf(
        Article(null, "Futures ebb as Powell's speech nears - Reuters","Aug 26 (Reuters) - U.S. stock index futures slipped on Friday as investors worried about hawkish signals from Federal Reserve Chair Jerome Powell at the annual Jackson Hole symposium amid fears of sl… [+2556 chars]","U.S. stock index futures slipped on Friday as investors worried about hawkish signals from Federal Reserve Chair Jerome Powell at the annual Jackson Hole symposium amid fears of slowing economic growth.", "2022-08-26T11:35:00Z", Source("reuters","Reuters"), "https://www.reuters.com/markets/europe/futures-ebb-powells-speech-nears-2022-08-26/","https://www.reuters.com/resizer/IqS0WNIjHDHAF8xN8gg1AkrhcAY=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/3KJYECNYSBOUXE4E2FFPLOSLUM.jpg"),
    Article(null,"Breakingviews - China-U.S. audit deal success is a long way off - Reuters","HONG KONG, Aug 26 (Reuters Breakingviews) - Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials ar… [+3364 chars]","Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials are nearing an accord allowing U.S. inspections in Hong Kong of mainland audit papers, the Wall Street Jou…","2022-08-26T03:55:00Z",Source("reuters","Reuters"),"https://www.reuters.com/breakingviews/china-us-audit-deal-success-is-long-way-off-2022-08-26/","https://www.reuters.com/resizer/Z10kPQ9m23PxivSgHwWaRRMoOYU=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/VI6DJLGGCJJRNKWAQQNCEUBENA.jpg"),


        Article(null,"Breakingviews - China-U.S. audit deal success is a long way off - Reuters","HONG KONG, Aug 26 (Reuters Breakingviews) - Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials ar… [+3364 chars]","Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials are nearing an accord allowing U.S. inspections in Hong Kong of mainland audit papers, the Wall Street Jou…","2022-08-26T03:55:00Z",Source("reuters","Reuters"),"https://www.reuters.com/breakingviews/china-us-audit-deal-success-is-long-way-off-2022-08-26/","https://www.reuters.com/resizer/Z10kPQ9m23PxivSgHwWaRRMoOYU=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/VI6DJLGGCJJRNKWAQQNCEUBENA.jpg"),
    Article(null,"Breakingviews - China-U.S. audit deal success is a long way off - Reuters","HONG KONG, Aug 26 (Reuters Breakingviews) - Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials ar… [+3364 chars]","Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials are nearing an accord allowing U.S. inspections in Hong Kong of mainland audit papers, the Wall Street Jou…","2022-08-26T03:55:00Z",Source("reuters","Reuters"),"https://www.reuters.com/breakingviews/china-us-audit-deal-success-is-long-way-off-2022-08-26/","https://www.reuters.com/resizer/Z10kPQ9m23PxivSgHwWaRRMoOYU=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/VI6DJLGGCJJRNKWAQQNCEUBENA.jpg"),
    Article(null,"Breakingviews - China-U.S. audit deal success is a long way off - Reuters","HONG KONG, Aug 26 (Reuters Breakingviews) - Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials ar… [+3364 chars]","Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials are nearing an accord allowing U.S. inspections in Hong Kong of mainland audit papers, the Wall Street Jou…","2022-08-26T03:55:00Z",Source("reuters","Reuters"),"https://www.reuters.com/breakingviews/china-us-audit-deal-success-is-long-way-off-2022-08-26/","https://www.reuters.com/resizer/Z10kPQ9m23PxivSgHwWaRRMoOYU=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/VI6DJLGGCJJRNKWAQQNCEUBENA.jpg")



    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // set content view after binding
        val view = binding.root
        setContentView(view)

        val mainGroup = binding.mainGroup
        var count = 0

        for(i in mainGroup.children)
        {
            if(i is TextView)
            {
                val content = article[count].title
                i.text = content
                count++
            }
        }

    }
}