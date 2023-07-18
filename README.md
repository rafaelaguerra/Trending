# Description
Fetch trending Android Github repositories from [GitHub REST API]("https://docs.github.com/en/rest?apiVersion=2022-11-28")

# Architecture
  - Clean architecture with having **3 modules** (presentation -> domain <- data).
    <img src="https://miro.medium.com/v2/resize:fit:1400/format:webp/1*1NOM7f3QboTIHlsYBKfjaw@2x.png" width="1024"/>
  - DI (Koin) 
   
## Presentation
 - MVVM + Livedata
## Domain
 - RxJava3
## Data
  - Retrofit with GsonConverterFactory + RxJava3CallAdapterFactory