# Description
Fetch trending Android Github repositories from [GitHub REST API]("https://docs.github.com/en/rest?apiVersion=2022-11-28")

# Architecture
  - Clean architecture with **Single module** - having 3 packages (presentation, domain, data) inside the app module.
    <img src="https://miro.medium.com/v2/resize:fit:1400/format:webp/1*u1_5RzcpjsKqQrgGNbxmog.png" width="1024"/>
  - DI (Koin)

   
## Presentation
 - MVVM + Livedata
## Domain
 - RxJava3
## Data
  - Retrofit with GsonConverterFactory + RxJava3CallAdapterFactory