
   // GeoLocation을 이용해서 접속 위치를 얻어옵니다
   navigator.geolocation.getCurrentPosition(function(position) {
    
    var lat = position.coords.latitude, // 위도
        lon = position.coords.longitude; // 경도

    
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
            level: 4 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); 

    /*-----------------------------------------------------------------------------------------*/ 
    
   $('#Search').click(function() {
      var Addr = $("#addr_1").val() 
         Addr += $("#addr_2").val();
      console.log(Addr)
      
      // 장소 검색 객체를 생성합니다
      var ps = new kakao.maps.services.Places();

      // 키워드로 장소를 검색합니다
      ps.keywordSearch(Addr, placesSearchCB);

      // 키워드 검색 완료 시 호출되는 콜백함수 입니다
      function placesSearchCB(data, status, pagination) {
         if (status === kakao.maps.services.Status.OK) {

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
            // LatLngBounds 객체에 좌표를 추가합니다
            var bounds = new kakao.maps.LatLngBounds();

            for (var i = 0; i < data.length; i++) {
               //displayMarker(data[i]);
               bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
            }

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
            map.setBounds(bounds);
            map.setZoomqble(false);
         }
      }
   });
   
   /*-----------------------------------------------------------------------------------------*/
   
      var json_url = "/json/Electricvehicle.json";
      
      // 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
      $.getJSON(json_url, function (data, textStatus) {
         var c_seq = null;
         var name = null;
         var LAT = null;
         var LNG = null;
         var closed_day = null;
         var open_time = null;
         var close_time = null;
         var slow_charge = null;
         var fast_charging = null;
         var fast_charging_type = null;
         var Parking_fee = null;
         var addr_1 = null;
         var addr_2 = null;
         var manager_name = null;
         var telno = null;
           
         $.each(data.Electricvehicle, function () {
        	 c_seq = this.c_seq;
             name = this.name;
             LAT = this.LAT;
             LNG = this.LNG;
             closed_day = this.closed_day;
             open_time = this.open_time;
             close_time = this.close_time;
             slow_charge = this.slow_charge;
             fast_charging = this.fast_charging;
   			 fast_charging_type = this.fast_charging_type;
   			 Parking_fee = this.Parking_fee;
   			 addr_1 = this.addr_1;
   			 addr_2 = this.addr_2;
   			 manager_name = this.manager_name;
   			 telno = this.telno;
   
               // 마커를 생성합니다
               var marker = new kakao.maps.Marker({
                   map: map, // 마커를 표시할 지도
                   position: new kakao.maps.LatLng(LNG, LAT), // 마커를 표시할 위치
                   clickable: true
               });
               
               
               // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
               var iwContent ='<div class="bAddr" style="height: 255px;">' +
               				  '<span class="title">' + name + '</span>' + 
                              '<div class="textcar">' + ' 휴점일 : ' + closed_day + '</div>' +
                              '<div class="textcar">' + ' 이용 시작 시간 : ' + open_time + '</div>' +
                              '<div class="textcar">' + ' 이용 종료 시간 : ' + close_time + '</div>' +
                              '<div class="textcar">' + ' 완속 충전 가능 여부: ' + slow_charge + '</div>' +
                              '<div class="textcar">' + ' 급속 충전 가능 여부: ' + fast_charging + '</div>' +
                              '<div class="textcar">' + ' 급속 충전 타입: ' + fast_charging_type + '</div>' +
                              '<div class="textcar">' + ' 주차료 부과 여부: ' + Parking_fee + '</div>' +
                              '<div class="textcar">' + ' 도로명주소: ' + addr_1 + '</div>' +
                              '<div class="textcar">' + ' 지번주소: ' + addr_2 + '</div>' +
                              '<div class="textcar">' + ' 관리업체 : ' + manager_name + '</div>' +
                              '<div class="textcar">' + '관리업체 전화번호: ' + telno + '</div>' +
                              '</div>',
                              
//                              var iwContent = 
//                                  ' <div class="wrap">' + 
//                                  '    <div class="info">' + 
//                                  '        <div class="title">' + 
//                                            name  + 
//                                  '        </div>' + 
//                                  '        <div class="body">' + 
//                                  '            <div class="desc">' + 
//                                  '                <div class="ellipsis">'
//                                                 + closed_day +
//                                  '             </div>' + 
//                                  '                <div style="margin=5px;"><a href="/Map_search_detail.do?kid_seq=' + KID_SEQ + '" target="_blank" class="link">더보기</a><a href="https://map.kakao.com/link/to/'+ KINDERNAME +','+ LNG +' , '+ LAT +'" style="color:blue" target="_blank">길찾기</a></div>' +
//                                  '            </div>' + 
//                                  '        </div>' + 
//                                  '    </div>' +     
//                                  '</div>',
                              
                   iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
   
               
               // 인포윈도우를 생성합니다
               var infowindow = new kakao.maps.InfoWindow({
                   content : iwContent,
                   removable : iwRemoveable
               });
   
               // 마커에 클릭이벤트를 등록합니다
               kakao.maps.event.addListener(marker, 'click', function() {
                     // 마커 위에 인포윈도우를 표시합니다
                     infowindow.open(map, marker);  
               });
           });
      });
});
   