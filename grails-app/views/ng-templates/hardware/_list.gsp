
<div class="page-header">
    <h1>Hardware List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
        <tr>
        
            <th data-sortable="accelerometer">Accelerometer</th>
            
            <th data-sortable="audioJack">Audio Jack</th>
            
            <th data-sortable="cpu">Cpu</th>
            
            <th data-sortable="fmRadio">Fm Radio</th>
            
            <th data-sortable="physicalKeyboard">Physical Keyboard</th>
            
            <th data-sortable="usb">Usb</th>
            
        </tr>
    </thead>
    <tbody>
        <tr data-ng-repeat="item in list" data-ng-click="show(item)">
            
            <td>{{item.accelerometer}}</td>
            
            <td>{{item.audioJack}}</td>
            
            <td>{{item.cpu}}</td>
            
            <td>{{item.fmRadio}}</td>
            
            <td>{{item.physicalKeyboard}}</td>
            
            <td>{{item.usb}}</td>
            
        </tr>
    </tbody>
</table>
