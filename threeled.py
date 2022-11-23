import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BOARD)
GPIO.setup(10,GPIO.OUT)
GPIO.setup(16,GPIO.OUT)
GPIO.setup(24,GPIO.OUT)

while True:
    GPIO.output(10,True);
    GPIO.output(16,False);
    GPIO.output(24,False);
    
    time.sleep(0.25)
    
    GPIO.output(10,False);
    GPIO.output(16,True);
    GPIO.output(24,False);

    time.sleep(0.25)
   
    GPIO.output(10,False);
    GPIO.output(16,False);
    GPIO.output(24,True);

