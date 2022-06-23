# App-Blocker-Kotlin-2.0
App allow users to select the app they need to block

This app is built using Kotlin Programming Language. It works for API Level 21 and above and should work for 98% of the android devices.

This is an improvement app in terms of design which gives users an option to select what apps they want to block.

# Layout and Logic
1. The app uses a Recycler View for the first screen to display any blocked apps.
2. As soon as the user hits add button, the second screen will display a list of apps available on the system and user will be able to select any app which they wish to block.
3. After selection, when the user presses the check/okay button, the control will move to the first activity.
4. User will need to press the 'show blocked apps' button in order to get the blocked apps list.
5. Lastly, the show all apps button will be pressed as shown in the prototype. Since we have the list of blocked apps now, whenever any of our last opened app matches any app in the list, the Lock Screen will take over.

# Improvements
1. I think a database can be used to store the list of blocked apps so that we can get rid of buttons and Observable class will handle the updation of list if any change is made by the user to the blocked list.
2. Using a Room Database with MVVM architecture will also save the data from configuration changes.
