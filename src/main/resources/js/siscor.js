
// $( document ).ready(function() {
//     console.log(siscorMinutaReader());
// });
//
siscorMinutaReader = function(){
  return $.ajax({
    type:'GET',
    url:AJS.contextPath()+'/plugins/servlet/siscorservlet',
    async: false
  }).responseText;
}
