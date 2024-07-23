package com.example.atl_unec.di.modules

//@Module
//@InstallIn(ActivityComponent::class)
//object RetrofitInstance {
//
//    fun provideBaseUrl() = "Constants.BASE_URL"
//
//    @Provides
//    @Singleton
//    fun provideRetrofitInstance(): MoviesApi =
//        Retrofit.Builder()
//            .baseUrl(provideBaseUrl())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(MoviesApi::class.java)
//}
//
//@Module
//@InstallIn(SingletonComponent::class)
//object ApiModule {
//    private const val BASE_URL = "https://restcountries.eu/rest/v2/"
//
//    @Singleton
//    @Provides
//    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
//        .apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//
//    @Singleton
//    @Provides
//    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
//        OkHttpClient
//            .Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .build()
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(BASE_URL)
//        .client(okHttpClient)
//        .build()
//
//
//
//
//    @Singleton
//    @Provides
//    fun provideApiService(retrofit: Retrofit): MoviesApi = retrofit.create(MoviesApi::class.java)
//
//    @Singleton
//    @Provides
//    fun providesRepository(apiService: MoviesApi) = TestMoviesRepository(apiService)
//}