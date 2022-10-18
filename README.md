# CapstoneNewsApp
# Anthony Catalano NYSOITS



# Week 8
Need to have
- [x] Offline mode
- [x] NewsDatabase implementation
- [x] Article with @Entity and @PimaryKey on a new id property
- [x] SourceDao with @Entity and @PrimaryKey on existing id property
- [x] DAO for article and source entities with getArticles()/getSources(), addArticles()/addSources(), and clearArticles() methods.
- [x] Article Search
- [x] EditText and Button to search articles
- [x] Repository and DAO methods to query the articles
- [x] Download Only Over WiFi
- [x] Create a Preference DataStore
- [x] Feed in the datastore to the repository and fetch the key/value from the datastore. 
This will determine whether or not you make a network call. If the value is “true” then the network call should be made only when on WiFi.
- [x]Toggle menu icon in toolbar or ToggleButton/Checkbox on the main, list layout
Nice to have
- [x] Offline mode
- [x] Relationships defined on Article and Source entities. One Source can have many Article so the relationship is one-to-many.
- [x] Article Search
- [x] Use SearchView or a more robust search UI - Used AndroidX Searchview!
- [] Use a PeriodicWorkRequest to periodically fetch new article data from the NewsAPI.See optional section for more details



# Week 7
 Need to have:
- [x]  A Details screen that adds some sort of filter to the image
- [x]  Proper use of WorkManager
- [x]  Use of input data
- [x]  Handling different states of WorkManager 
- [x]  Proper use of constraints (Only apply the filter if battery is not low) 
- [x]  Adding 3 constraints to the Worker


Nice to have:
- [x]  Saving the file using FileOutputStream
- [x]  Apply more than one worker to the WorkManager
- [ ] You could add multiple image filter types (perhaps a blurry image filter and a sepia filter)
- [x]  You could also wrap the article fetching logic (retrofit call to the API) behind a worker!
- [ ] Or, come up with your own set of work to wrap behind a Worker!


# Week 6
Need to have:
- [x]  Retrofit with coroutines is used for the networking layer
- [x]  Appropriate scope is used for each coroutine
- [x]  Handle coroutine exceptions
- [x] All network requests are done on a background thread

Nice to have:
- [ ] Handle UI responsively when making network requests, e.g. show loading indicator until response returns
- [ ] Implement Repository (just for API layer - there is no local database yet)
- [ ] Proper use of MutableLiveData and LiveData with proper encapsulation


# Week 5
Need to have:
- [x] News articles are fetched from News API instead of hardcoded data
- [x] Proper parsing of JSON data is done
- [x] Error handling - All exceptions/errors are handled gracefully (Network exception) by showing error messages 
- [x] Internet check before making network calls
- [ ] Refresh button functionality to get the latest news data
Never went over how to create menu buttons. Articles researched dont work with page setup

Nice to have:
- [] Using Result/sealed classes for different error states (Loading, Success, Failure)
- [] Making custom screens/dialogs for different error states 
- [] Use of logging interceptor to analyze each network request
- [] Using Glide to load images


# Week 4
Need to have:
- [x] An item row layout file
- [x] Use of RecyclerView to display the news data
- [x] Display news details in a separate screen
- [x] Clicking on a news article should take users to the details screen 

Nice to have:
- [] Swipe to delete an item from the displayed ArrayList in Recyclerview
- [] Use of Jetpack Navigation
- [] Single activity with multiple fragments
- [x] Refined UI design (Bolder news heading, lighter description font styles, use of CardView, appropriate padding, margins–you’re free to use your creativity here)
- [x] Use of SharedPreferences to persist the news data for offline use



# Week 3
Need to have:
- [x] Switch following Source properties to use enum classes:
Category
Language
Country
- [x] Create a NewsService with a single method to get articles.
- [x] Reference NewsService from Activity and get the articles.
- [x] Your main activity layout should have a ScrollView at the top level.
- [x] Inflate a custom layout and loop through articles and set text (like title, author, etc) on the layout.
- [x] There should be an equivalent number of articles for each article element in your list.
Nice to have:
- [] Convert NewsService to an interface and create an InMemoryNewsServiceImpl class that implements NewsService to use in the Activity.  
- [x] Use a custom view called ArticleView that wraps the custom layout.
- [] Add nulls in your articles list and use the filter() extension function!
Note: Not enough time to complete Nice to have due to Holiday weekend



# Week 2
## To get a Good Job (Meets Expectations) grade: 
- [x] Data classes are created for Article and Source
- [x] Nullable types are used for certain properties which can be null such as author, source id. Other properties can be checked from News API documentation.
- [x] Hardcoded news data is saved in ArrayList
- [x] Layout for main activity is created
- [x] Loops are used for iterating the list and data is shown on the screen
- [x] Null checks are done using if/else statements
- [x] Code is divided into multiple functions instead of doing everything in onCreate(). At least one new function should be created.

## Nice to have (for an Above and Beyond grade)
- [x] Use default values with functions
- [x] Use maps to store hardcoded data instead of ArrayList



