/***************************************
(C) www.dhtmlgoodies.com, November 2005
www.dhtmlgoodies.com
Alf Magne Kalleland
****************************************/

var shuffleQuestions = true;	/* Shuffle questions ? */
var shuffleAnswers = true;	/* Shuffle answers ? */
var lockedAfterDrag = true;	/* Lock items after they have been dragged, i.e. the user get's only one shot for the correct answer */

function endGame() {
// This function is called when everything is solved
}


function undo() {

}

/* TIMER  START */
var totalSeconds = 0;
function countTimer() {
   ++totalSeconds;
 function pad ( val ) { return val > 9 ? val : "0" + val; }
   var hour = Math.floor(totalSeconds /3600);
   var minute = Math.floor((totalSeconds - hour*3600)/60);
   var seconds = totalSeconds - (hour*3600 + minute*60);
   document.getElementById("seconds").innerHTML=pad(totalSeconds%60);
   document.getElementById("timerVis").innerHTML=(":");
   document.getElementById("minutes").innerHTML=pad(parseInt(totalSeconds/60,10));
}
var timerVar;
/* TIMER  END*/

//changing button name and function each click
function endMePlease() {
  //on start button is "Start", onclick it's changed to "End"
  //load is called - load currently ONLY pulls the JSON file
  var elem = document.getElementById("startBtn");
  if (elem.value=="Start") {
    elem.value = "End";
    document.getElementById("instructions").style.display = 'none';
    //startTimer();
    timerVar = setInterval(countTimer, 1000);
    countTimer();
    //startGame(); game appears after this
    //load JSON
    //load();
    termDescription.style.visibility = 'visible';
    termUsed.style.visibility = 'visible';
  }
  //onclick "End" it's changed to "Show Score"
  //endGame is called
  else if (elem.value=="End") {
    elem.value = "Show Score";
    endGame();
    clearInterval(timerVar);
    //stop timer
    //setTimeout();
  }
  //onclick "Show Score" it's changed to "Play Again"
  //showScore is called
  else if (elem.value=="Show Score") {
    elem.value = "Play Again";
    //changeColor();
    showScore();
  }
  //"Play Again" refreshes page
  else if (elem.value=="Play Again") {
  dragDropResetForm();
  }
}


/* Don't change anything below here */
var dragContentDiv = false;
var dragContent = false;

var dragSource = false;
var dragDropTimer = -1;
var destinationObjArray = new Array();
var destination = false;
var dragSourceParent = false;
var dragSourceNextSibling = false;
var termUsed;
var termDescription;
var sourceObjectArray = new Array();
var arrayOfEmptyBoxes = new Array();
var arrayOfAnswers = new Array();
var count = 0;

function getTopPos(inputObj) {
  if(!inputObj || !inputObj.offsetTop)return 0;
  var returnValue = inputObj.offsetTop;
  while((inputObj = inputObj.offsetParent) != null)returnValue += inputObj.offsetTop;
  return returnValue;
}

function getLeftPos(inputObj) {
  if(!inputObj || !inputObj.offsetLeft)return 0;
  var returnValue = inputObj.offsetLeft;
  while((inputObj = inputObj.offsetParent) != null)returnValue += inputObj.offsetLeft;
  return returnValue;
}

function cancelEvent() {
  return false;
}

function initDragDrop(e)
{
if(document.all)e = event;
if(lockedAfterDrag && this.parentNode.parentNode.id=='termDescription')return;
dragContentDiv.style.left = e.clientX  + Math.max(document.documentElement.scrollLeft,document.body.scrollLeft) + 'px';
dragContentDiv.style.top = e.clientY  + Math.max(document.documentElement.scrollTop,document.body.scrollTop) + 'px';
dragSource = this;
dragSourceParent = this.parentNode;
dragSourceNextSibling = false;
if(this.nextSibling)dragSourceNextSibling = this.nextSibling;
if(!dragSourceNextSibling.tagName)dragSourceNextSibling = dragSourceNextSibling.nextSibling;

dragDropTimer=0;
timeoutBeforeDrag();

return false;
}

function timeoutBeforeDrag(){
  if(dragDropTimer>=0 && dragDropTimer<10){
    dragDropTimer = dragDropTimer +1;
    setTimeout('timeoutBeforeDrag()',10);
    return;
  }
  if(dragDropTimer>=10){
    dragContentDiv.style.display='block';
    dragContentDiv.innerHTML = '';
    dragContentDiv.appendChild(dragSource);
  }
}

function dragDropMove(e)
{
if(dragDropTimer<10){
  return;
}

if(document.all)e = event;

var scrollTop = Math.max(document.documentElement.scrollTop,document.body.scrollTop);
var scrollLeft = Math.max(document.documentElement.scrollLeft,document.body.scrollLeft);

dragContentDiv.style.left = e.clientX + scrollLeft + 'px';
dragContentDiv.style.top = e.clientY + scrollTop + 'px';

var dragWidth = dragSource.offsetWidth;
var dragHeight = dragSource.offsetHeight;


var objFound = false;

var mouseX = e.clientX + scrollLeft;
var mouseY = e.clientY + scrollTop;

destination = false;
for(var no=0;no<destinationObjArray.length;no++){
  var left = destinationObjArray[no]['left'];
  var top = destinationObjArray[no]['top'];
  var width = destinationObjArray[no]['width'];
  var height = destinationObjArray[no]['height'];

  destinationObjArray[no]['obj'].className = 'destinationBox';
  var subs = destinationObjArray[no]['obj'].getElementsByTagName('DIV');
  if(!objFound && subs.length==0){
    if(mouseX < (left/1 + width/1) && (mouseX + dragWidth/1) >left && mouseY < (top/1 + height/1) && (mouseY + dragHeight/1) >top){
      destinationObjArray[no]['obj'].className='dragContentOver';
      destination = destinationObjArray[no]['obj'];
      objFound = true;
    }
  }
}

sourceObjectArray['obj'].className='';

if(!objFound){
  var left = sourceObjectArray['left'];
  var top = sourceObjectArray['top'];
  var width = sourceObjectArray['width'];
  var height = sourceObjectArray['height'];

  if(mouseX < (left/1 + width/1) && (mouseX + dragWidth/1) >left && mouseY < (top/1 + height/1) && (mouseY + dragHeight/1) >top){
    destination = sourceObjectArray['obj'];
    sourceObjectArray['obj'].className='dragContentOver';
  }
}
return false;
}


function dragDropEnd()
{
if(dragDropTimer<10){
  dragDropTimer = -1;
  return;
}
dragContentDiv.style.display='none';
sourceObjectArray['obj'].style.backgroundColor = '#FFF';
if(destination){
  destination.appendChild(dragSource);
  destination.className='destinationBox';

  // Check if position is correct, i.e. correct answer to the question

  if(!destination.id || destination.id!='termUsed'){
    var previousEl = dragSource.parentNode.previousSibling;
    if(!previousEl.tagName)previousEl = previousEl.previousSibling;

    var numericId = previousEl.id.replace(/[^0-9]/g,'');
    var numericIdSource = dragSource.id.replace(/[^0-9]/g,'');

    if(numericId==numericIdSource){
      dragSource.className='bcorrectAnswer';
      checkAllAnswers();
      //count right answers
      count += 1;
    }
    else
      dragSource.className='bwrongAnswer';
  }
  if(destination.id && destination.id=='termUsed'){
    dragSource.className='dragDropSmallBox';
  }

}else{
  if(dragSourceNextSibling)
    dragSourceNextSibling.parentNode.insertBefore(dragSource,dragSourceNextSibling);
  else
    dragSourceParent.appendChild(dragSource);
}
dragDropTimer = -1;
dragSourceNextSibling = false;
dragSourceParent = false;
destination = false;
}

function checkAllAnswers()
{
for(var no=0;no<arrayOfEmptyBoxes.length;no++){
  var sub = arrayOfEmptyBoxes[no].getElementsByTagName('DIV');
  if(sub.length==0)return;

  if(sub[0].className!='correctAnswer'){
    return;
  }

}
endGame();
}

    function resetPositions()
    {
    if(dragDropTimer>=10)return;

    for(var no=0;no<destinationObjArray.length;no++){
      if(destinationObjArray[no]['obj']){
        destinationObjArray[no]['left'] = getLeftPos(destinationObjArray[no]['obj'])
        destinationObjArray[no]['top'] = getTopPos(destinationObjArray[no]['obj'])
      }

    }
    sourceObjectArray['left'] = getLeftPos(termUsed);
    sourceObjectArray['top'] = getTopPos(termUsed);
    }

function initDragDropScript() {
  dragContentDiv = document.getElementById('dragContent');

  termUsed = document.getElementById('termUsed');
  termUsed.onselectstart = cancelEvent;
  var divs = termUsed.getElementsByTagName('DIV');
  var answers = new Array();

  for(var no=0;no<divs.length;no++){
    if(divs[no].className=='dragDropSmallBox'){
      divs[no].onmousedown = initDragDrop;
      answers[answers.length] = divs[no];
      arrayOfAnswers[arrayOfAnswers.length] = divs[no];
    }
  }

  if(shuffleAnswers){
    for(var no=0;no<(answers.length*10);no++){
      var randomIndex = Math.floor(Math.random() * answers.length);
      termUsed.appendChild(answers[randomIndex]);
    }
  }

  sourceObjectArray['obj'] = termUsed;
  sourceObjectArray['left'] = getLeftPos(termUsed);
  sourceObjectArray['top'] = getTopPos(termUsed);
  sourceObjectArray['width'] = termUsed.offsetWidth;
  sourceObjectArray['height'] = termUsed.offsetHeight;

  termDescription = document.getElementById('termDescription');

  termDescription.onselectstart = cancelEvent;
  var divs = termDescription.getElementsByTagName('DIV');

  var questions = new Array();
  var questionsOpenBoxes = new Array();

  for(var no=0;no<divs.length;no++){
    if(divs[no].className=='destinationBox'){
      var index = destinationObjArray.length;
      destinationObjArray[index] = new Array();
      destinationObjArray[index]['obj'] = divs[no];
      destinationObjArray[index]['left'] = getLeftPos(divs[no])
      destinationObjArray[index]['top'] = getTopPos(divs[no])
      destinationObjArray[index]['width'] = divs[no].offsetWidth;
      destinationObjArray[index]['height'] = divs[no].offsetHeight;
      questionsOpenBoxes[questionsOpenBoxes.length] = divs[no];
      arrayOfEmptyBoxes[arrayOfEmptyBoxes.length] = divs[no];
    }
    if(divs[no].className=='dragDropSmallBox'){
      questions[questions.length] = divs[no];
    }

  }

  if(shuffleQuestions){
    for(var no=0;no<(questions.length*10);no++){
      var randomIndex = Math.floor(Math.random() * questions.length);

      termDescription.appendChild(questions[randomIndex]);
      termDescription.appendChild(questionsOpenBoxes[randomIndex]);

      destinationObjArray[destinationObjArray.length] = destinationObjArray[randomIndex];
      destinationObjArray.splice(randomIndex,1);

      questionsOpenBoxes[questionsOpenBoxes.length] = questionsOpenBoxes[randomIndex];
      questionsOpenBoxes.splice(randomIndex,1);
      questions[questions.length] = questions[randomIndex];
      questions.splice(randomIndex,1);
    }
}

document.documentElement.onmouseup = dragDropEnd;
document.documentElement.onmousemove = dragDropMove;
setTimeout('resetPositions()',150);
window.onresize = resetPositions;
}

function showScore(){
//display # of correct answers
  if (count == 5){
      window.alert("Perfect Score!");
  }
  else if (count == 1){
      window.alert("You have " + count + " correct answer!");
  }
  else if (1 < count < 5){
      window.alert("You have " + count + " correct answers!");
  }
  else{
      window.alert("You have no correct answers!");
  }


}

/* Reset the form */
function dragDropResetForm()
{
for(var no=0;no<arrayOfAnswers.length;no++){
  arrayOfAnswers[no].className='dragDropSmallBox'
  termUsed.appendChild(arrayOfAnswers[no]);
}
//refreshes window
 window.location.reload();
}

window.onload = initDragDropScript;
