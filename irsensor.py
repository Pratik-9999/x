import RPi.GPIO as GPIO
import time
#sensor 16
#led 18
GPIO.setmode(GPIO.BOARD)
GPIO.setup(16,GPIO.IN)
GPIO.setup(18,GPIO.OUT)
GPIO.output(18,False)
print ("IR sensor Ready....")
print (" ")
try:
    while True:
        if GPIO.input(16):
                          GPIO.output(18,False)
                          print("Object detected")
                          while GPIO.input(16):
                                time.sleep(1)
        else:
         GPIO.output(18,True)
    
except KeyboardInterrupt:
        GPIO.cleanup
                                                                                            