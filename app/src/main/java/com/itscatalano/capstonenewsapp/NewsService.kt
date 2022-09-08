package com.itscatalano.capstonenewsapp

import android.os.Bundle

class NewsService {


     private val article = listOf(
        Article(
            null,
            "Futures ebb as Powell's speech nears - Reuters",
            "Aug 26 (Reuters) - U.S. stock index futures slipped on Friday as investors worried about hawkish signals from Federal Reserve Chair Jerome Powell at the annual Jackson Hole symposium amid fears of sl… [+2556 chars]",
            "U.S. stock index futures slipped on Friday as investors worried about hawkish signals from Federal Reserve Chair Jerome Powell at the annual Jackson Hole symposium amid fears of slowing economic growth.",
            "2022-08-26T11:35:00Z",
            Source(
                "reuters",
                "Reuters",
                "My Sample Desc1",
                "www.test1.com",
                CategoryType.science,
                LanguageType.en,
                CountryType.ca
            ),
            "https://www.reuters.com/markets/europe/futures-ebb-powells-speech-nears-2022-08-26/",
            "https://www.reuters.com/resizer/IqS0WNIjHDHAF8xN8gg1AkrhcAY=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/3KJYECNYSBOUXE4E2FFPLOSLUM.jpg"
        ),
        Article(
            null,
            "Breakingviews - China-U.S. audit deal success is a long way off - Reuters",
            "HONG KONG, Aug 26 (Reuters Breakingviews) - Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials ar… [+3364 chars]",
            "Sometimes the hardest yards are put in agreeing deal principles; other times, the real work only starts after that point. American and Chinese officials are nearing an accord allowing U.S. inspections in Hong Kong of mainland audit papers, the Wall Street Jou…",
            "2022-08-26T03:55:00Z",
            Source(
                "reuters",
                "Reuters",
                "My Sample Desc1",
                "www.test1.com",
                CategoryType.science,
                LanguageType.en,
                CountryType.ca
            ),
            "https://www.reuters.com/breakingviews/china-us-audit-deal-success-is-long-way-off-2022-08-26/",
            "https://www.reuters.com/resizer/Z10kPQ9m23PxivSgHwWaRRMoOYU=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/VI6DJLGGCJJRNKWAQQNCEUBENA.jpg"
        ),
        Article(
            "msmash",
            "Amazon Is Looking To Buy Electronic Arts, Report Says",
            "Never ask two questions in a business letter. The reply will discuss\\r\\nthe one you are least interested, and say nothing about the other.",
            "An anonymous reader shares a report: According to GLHF sources, Amazon will announce today that it has put in a formal offer to acquire Electronic Arts (EA), the publisher behind Apex Legends, FIFA, Madden, and more. Rumors have been circling online for a few…",
            "2022-08-26T11:28:00Z",
            Source(
                null,
                "Slashdot.org",
                "My Sample Desc1",
                "www.test1.com",
                CategoryType.science,
                LanguageType.en,
                CountryType.ca
            ),
            "https://slashdot.org/story/22/08/26/1127257/amazon-is-looking-to-buy-electronic-arts-report-says",
            "https://a.fsdn.com/sd/topics/business_64.png"
        ),
        Article(
            "aweinman@businessinsider.com (Aaron Weinman)",
            "Doctored bank statements and a decade-long graft. This banker has been accused of stealing $50 million in a lawsuit that claims the money went toward hotels in New York, Miami, and land in the Catskills.",
            "Hi. Aaron Weinman here. Today's top story digs into a wealth-management banker who is being accused of stealing $50 million and investing that money in luxury hotels.\r\nOver some 10 years, Dubai-based… [+4947 chars]",
            "The Gupta family from India who control shipping company Astra Global have accused Ganesh Narayan in a lawsuit of doctoring bank statements and concealing a long-running grift that robbed the family of millions of dollars.",
            "2022-08-26T11:35:00Z",
            Source(
                null,
                "Hipertextual",
                "My Sample Desc1",
                "www.test1.com",
                CategoryType.science,
                LanguageType.en,
                CountryType.ca
            ),
            "https://hipertextual.com/2022/08/iphone-14-morado-filtrado",
            "https://imgs.hipertextual.com/wp-content/uploads/2022/07/iPhone-14-Pro-Purple-Side-by-Side-Black-scaled.jpg"
        ),
        Article(
            "Tushar Mehta",
            "Samsung’s Galaxy Watch is great, but the S Pen would make it amazing",
            "The Samsung Galaxy Watch is one of the best smartwatches around. Until 2021, Samsungs smartwatches ran on a custom operating system called Tizen. But with the launch of the Galaxy Watch 4 series, the… [+7280 chars]",
            "Samsung's ecosystem is the next best thing to Apple's walled garden, and S Pen support on the Galaxy Watch can make it more unified and completely gapless.",
            "2022-08-26T10:00:01Z",
            Source(
                null,
                "Digital Trends",
                "My Sample Desc1",
                "www.test1.com",
                CategoryType.science,
                LanguageType.en,
                CountryType.ca
            ),
            "https://www.digitaltrends.com/mobile/samsung-galaxy-watch-needs-s-pen-support-why/",
            "https://www.digitaltrends.com/wp-content/uploads/2022/08/Galaxy-Watch-S22-Ultra-Stylus.jpg?p=1"
        ),

        )

 fun getArticleByIndex(articleNum: Int): Article {
    return article[articleNum]
}

fun getAllArticles(): List<Article> {
    return article
}

}