
<div class="page-header">
    <h1>Display List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
        <tr>
        
            <th data-sortable="screenResolution">Screen Resolution</th>
            
            <th data-sortable="screenSize">Screen Size</th>
            
            <th data-sortable="touchScreen">Touch Screen</th>
            
        </tr>
    </thead>
    <tbody>
        <tr data-ng-repeat="item in list" data-ng-click="show(item)">
            
            <td>{{item.screenResolution}}</td>
            
            <td>{{item.screenSize}}</td>
            
            <td>{{item.touchScreen}}</td>
            
        </tr>
    </tbody>
</table>
