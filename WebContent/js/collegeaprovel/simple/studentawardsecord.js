// JavaScript Document
var $grid;
var manager, g;

 var alert = function (content)
        {
            $.ligerDialog.alert(content);
        };
        
        var gridManager = null;
        $(function ()
        {  
            g = manager = $grid = $("#maingrid").ligerGrid({
                columns:[
                  { display: '提交者', name: 'submitUser', align: 'left', width: 100, minWidth: 60 },
                  { display: '信息名称', name: 'name', align: 'left', minWidth: 140 },
	              { display: '审批状态', name: 'Status', width: 120  },
	              { display: '操作', isAllowHide: false, width: 60, frozen: true,
	                 	render: function (row)
	                     {
	                 		var html = '<a href="collegeAchStatus/studentAwardsRecord.action?recordId='+row.id+'">查看详细</a>';
	                         return html;
	                     }
	                 }
	              ], dataAction: 'server', data: rows, sortName: 'id',
			     width: '100%', height: '100%', pageSize: 30,rownumbers:true,
			     checkbox : true,
			   
			     cssClass: 'l-grid-gray', 
			     heightDiff: -6
			 });
			 show();
			
			gridManager = $("#maingrid").ligerGetGridManager();
			
			 $("#pageloading").hide();
                       
        });
        function GetxmlhttpObject()
    	{
    	   var xmlhttp;
    	   try
		   {
    		   // Firefox, Opera 8.0+, Safari
    		   xmlhttp = new XMLHttpRequest();
		   }
    	   catch (e)
		   {
    		   // Internet Explorer
    		   try
    		   {
    			   xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    		   }
    		   catch (e)
    		   {
    			   try
    			   {
    				   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    			   }
    			   catch (e)
    			   {
    				   alert("您的浏览器不支持AJAX！");
    				   xmlhttp = false;
    			   }
    		   }
		   }
    	   return xmlhttp;
    	}
    
	 function show()
     {
         var jsonObj = {};
         
         jsonObj.Rows = rows;
         $grid.set({ data: jsonObj }); 
     }
	   
	    
     var rows = [];