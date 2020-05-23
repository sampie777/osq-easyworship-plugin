
Plugin for OBS Scene Que for controlling EasyWorship 2009 projection software. It creates this connection by simulating virtual keystrokes. For each action, the EasyWorship window will be focused, the keystroke will be executed, and the OBS Scene Que will retrieve focus again.

### Usage

Edit the properties file `osq-easyworship.properties` (will be auto generated after first plugin use) with the correct Windows key codes matching to your EasyWorship key codes (`C:\ProgramData\Softouch\EasyWorship\Settings\HotKeys.ini`). You can do this by copying the key->value mappings from the `HotKeys.ini` to `osq-easyworship.properties`. The contents of `osq-easyworship.properties` will then look as follows:

```properties
SlideNextKeys=78
SlidePrevKeys=80
SchedulePrevKeys=33
GoLiveNextKeys=34
BlackScreenKeys=C-66
ClearScreenKeys=C-67
LogoScreenKeys=C-76
```

You can leave values like `13, 12, C-43`. The plugin will use only the first value. To simulate a CTRL + key press, prepend the key code with `C-`. 

#### Dirty Hacking

EasyWorship 2009 has a bug that you cannot display the previous song, only the next song. This plugin works around this bug by moving up in the schedule list by two items (using the SchedulePrev shortkey), and then hit the GoLiveNext shortkey.
