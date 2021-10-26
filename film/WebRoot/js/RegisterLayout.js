//昵称验证
		 function nickname(){ 
                var div = document.getElementById("div1"); 
                div.innerHTML = ""; 
                var nickname= document.getElementById("text1").value; 
                if (nickname== "") { 
                div.innerHTML = "用户名不能为空！"; 
                document.getElementById("text1").focus(); 
                return false; 
            } 
                if (nickname.length < 2 || nickname.length > 10){ 
                div.innerHTML = "长度2-10个字符"; 
               document.getElementById("text1").select(); 
                return false; 
            } 
			 div.innerHTML = "✓"; 
                return true;
        }
		 //用户名验证
            function checkname(){ 
                var div = document.getElementById("div2"); 
                div.innerHTML = ""; 
                var name1 = document.getElementById("text2").value; 
                if (name1 == "") { 
                div.innerHTML = "用户名不能为空！"; 
                document.getElementById("text2").focus(); 
                return false; 
            } 
                if (name1.length < 4 || name1.length > 16) { 
                div.innerHTML = "长度4-16个字符"; 
                document.getElementById("text2").select(); 
                return false; 
            } 
                var charname1 = name1.toLowerCase(); 
                for (var i = 0; i < name1.length; i++) { 
                var charname = charname1.charAt(i); 
                if (!(charname >= 0 && charname <= 9) && (!(charname >= 'a' && charname <= 'z')) && (charname != '_')) { 
                    div.innerHTML = "用户名包含非法字符"; 
                    document.getElementById("text2").select(); 
                    return false; 
                } 
            } 
				 div.innerHTML = "✓"; 
                return true;
        }

            //密码验证
            function checkpassword(){ 
                var div = document.getElementById("div3"); 
                div.innerHTML = ""; 
                var password = document.getElementById("text3").value; 
                if (password == "") { 
                div.innerHTML = "密码不能为空"; 
               document.getElementById("text3").focus(); 
                return false; 
            } 
                if (password.length < 8 || password.length > 16) { 
                div.innerHTML = "密码长度为8-16位"; 
                document.getElementById("text3").select(); 
                return false; 
                } 
				 div.innerHTML = "✓"; 
                return true; 
        }

            function checkrepassword(){ 
                var div = document.getElementById("div4"); 
                div.innerHTML = ""; 
                var password =document.getElementById("text3").value; 
                var repass =document.getElementById("text4").value; 
                if (repass == "") { 
                div.innerHTML = "密码不能为空"; 
                document.getElementById("text4").focus(); 
                return false; 
            } 
                if (password != repass) { 
                div.innerHTML = "密码不一致"; 
                document.getElementById("text4").select(); 
                return false; 
            } 
				 div.innerHTML = "✓"; 
                return true; 
        }
        //手机号验证
            function getmob(){ 
                var div = document.getElementById("div5"); 
                div.innerHTML = ""; 
                var mob= document.getElementById("text5").value; 
                if (mob == "") { 
                div.innerHTML = "手机号码不能为空"; 
               document.getElementById("text5").focus(); 
                return false; 
            } 
				if (mob.length!=11) { 
                div.innerHTML = "请输入正确的手机号码"; 
                document.getElementById("text5").select(); 
                return false; 
            } 
                var mob1 = mob.toLowerCase(); 
                for (var i = 0; i < mob1.length; i++) { 
                var  mob =mob1.charAt(i); 
                if ((mob>= 'a'&&mob<= 'z')&&(mob != '_')) { 
                    div.innerHTML = "手机号中包含非法字符"; 
                    document.getElementById("text5").select(); 
                    return false; 
                } 	
        }
				 div.innerHTML = "✓"; 
                return true; 
			}

            function check(){ 
            if (nickname()&&checkname() && checkpassword() && checkrepassword()&&getmob()) { 
            return true; 
            } 
            else { 
            return false; 
        } 
    } // JavaScript Document