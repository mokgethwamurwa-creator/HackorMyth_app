//Hack or Myth

Quiz app for IMAD5112. 

by Mokgethwa Murwa st10539573

//What is it
Android app that shows myths. You pick Hack or Myth for each question. Gives you a score at the end.

The app is made with Kotlin + 3 activities.

// Screens
1. On Main screen- Just a start button
2. On quiz screen - Shows question, Hack/Myth buttons, tells you right/wrong 
3. On score screen - Final score like "3/5"

// how the app works
'MainActivity' → 'QuizActivity' → 'ScoreActivity'. Used 'Intent' to send the score.

Questions are hard-coded in a list. Used 'findviewbyid' and 'LinearLayout' to keep it simple.

// the problems that i had
- App kept crashing on last question. I Fixed it by adding 'ScoreActivity' to 'AndroidManifest.xml'
- I Had 'scoreActivity' instead of 'ScoreActivity'. Android Studio gave me red errors until I fixed the capital S

// to run
Clone repo → Open in Android Studio → Run

 // github
I Pushed my code after each part so I don't lose it. Added GitHub Actions so it builds automatically when I push. 

// Video
video link ' https://youtu.be/v73t6_cpxgc '

