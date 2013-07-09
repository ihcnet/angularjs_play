
<div class="page-header">
    <h1>Connectivity List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
        <tr>
        
            <th data-sortable="bluetooth">Bluetooth</th>
            
            <th data-sortable="cell">Cell</th>
            
            <th data-sortable="gps">Gps</th>
            
            <th data-sortable="infrared">Infrared</th>
            
            <th data-sortable="wifi">Wifi</th>
            
        </tr>
    </thead>
    <tbody>
        <tr data-ng-repeat="item in list" data-ng-click="show(item)">
            
            <td>{{item.bluetooth}}</td>
            
            <td>{{item.cell}}</td>
            
            <td>{{item.gps}}</td>
            
            <td>{{item.infrared}}</td>
            
            <td>{{item.wifi}}</td>
            
        </tr>
    </tbody>
</table>
