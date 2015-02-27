// http://www.sussex.ac.uk/Users/nc81/modules/cm1/scfiles/3.3%20Sequencing.html
SynthDef(\drum,{ arg freq=45, amp=0.5, pan=0.0;  
  var env; 
  env = EnvGen.ar(  Env([0,1,1,0],[0.01, 0.1, 0.2]),  doneAction:2);  
  Out.ar(0,  Pan2.ar(Blip.ar(freq) * env * amp, pan))  
}).add;


// 4.do({ Synth(\event); 1.0.wait; }).fork 
{ Synth(\event); 1.0.wait; }



(
// used to lag pitch
{
    SinOsc.ar(                              // sine wave
        Lag.kr(                             // lag the modulator
            LFPulse.kr(4, 0, 0.5, 50, 400), // frequency modulator
            Line.kr(0, 1, 15)               // modulate lag time
        ),
        0,                                  // phase
        0.3                                 // sine amplitude
    )
}.play
)


SynthDef(\chord,{ arg freq=220, amp=0.5, pan=0.0, nNotes=3, ;
  var env; 
  env = EnvGen.ar(  Env([0,1,1,0],[0.01, 0.1, 0.2]),  doneAction:2);  
  Out.ar(0,  Pan2.ar(Blip.ar(freq) * env * amp, pan))  
}).add;
