
<g:set var="ConnectivitySubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
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
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.bluetooth}}</td>
        
        <td>{{x.cell}}</td>
        
        <td>{{x.gps}}</td>
        
        <td>{{x.infrared}}</td>
        
        <td>{{x.wifi}}</td>
        
    </tr>
    </tbody>
</table>