<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
      <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   </head>
   
   <style>
       body * {
           font-family: 'Jua';
       }
       div.shopicon{
          margin: 30px 100px;
       }
       div.shopicon *{
          cursor: pointer;
          margin-right: 30px;
          font-size:50px;
       }
       div.list{
          margin:30px 50px;
          height: 800px;
          width: 100%;
          font-size: 20px;
       }
      div.box{
         width:280px;
         height:500px;
         text-align: center;
         border:5px solid gray;
         border-radius: 20px;
         float: left;
         margin-right: 30px;
         margin-bottom: 10px;
         font-size: 30px;
      }
      div.box figure img{
         width: 250px;
         height: 250px;
         border-radius: 30px;
         margin-top: 10px;
      }
      
   </style>
   <body>
   
      <div id="test">
         
      </div>
   
   
   <script type="text/javascript">
      $(function() {
         $.get("https://boonakitea.cyclic.app/api/all", {}, function(res, err) {
            if(err === 'success') {
               var data = res;
               
               let s="";
               s+=
                  `
                  <table class="table table-bordered shoptb" style="text-align:center">
                     <thead>
                        <tr>
                           <th width="50">number</th>
                           <th width="100">altnames</th>
                           <th width="100">image</th>
                           <th width="200">caffeine</th>
                           <th width="100">caffeineLevel</th>
                           <th width="100">colorDescription</th>
                        </tr>
                     </thead>
                  `;
               
               data.forEach(function(el, idx) {
                  let image = el.image;
                  let altnames = el.altnames;
                  let caffeine = el.caffeine;
                  let caffeineLevel = el.caffeineLevel;
                  let colorDescription = el.colorDescription;
                  
                  
                  s+=
                  `
                  <tbody>
                     <tr>
                        <td>\${idx+1}</td>
                        <td align="left">
                           <img src="\${image}" width=80 border=1
                              hspace=5>
                              \${altnames}
                        </td>
                        <td>\${caffeine}</td>
                        <td align="right">\${caffeineLevel}</td>
                        <td>\${colorDescription}</td>
                     </tr>
                  </tbody>
                  `;
               });
               
               s+="</table>";
               $("#test").html(s);
               
            } else {
               alert('Error');
            }
         });
      });
      
   </script>   
   </body>
</html>