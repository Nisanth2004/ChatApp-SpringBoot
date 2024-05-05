## Step 1: Create a WebConfig Class and do a configuration(WebSocketConfig)

## Step 2: Create a another config class Event Listerner to listen the session ended by any user.That is to inform that to other user to i.e "X" is ended .

## Step 3: Create a logic with the help of ChatController

## Step 4: Create a ChatMesssage class and Messagetype ENUM

## Step 5: Create a send message method in Controller and create a addUser method

## Step 6: Create a handleWebSocketDisconnectListener in Listener Class to send the message to all

## Next to Create a Frontend
 
   1.Create A HTML file,CSS file,JS file 
   
   2.Inside HTML file put this script tag
   ###
       <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

