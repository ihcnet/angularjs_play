
<div class="page-header">
    <h1>Battery List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
        <tr>
        
            <th data-sortable="standByTime">Stand By Time</th>
            
            <th data-sortable="talkTime">Talk Time</th>
            
            <th data-sortable="type">Type</th>
            
        </tr>
    </thead>
    <tbody>
        <tr data-ng-repeat="item in list" data-ng-click="show(item)">
            
            <td>{{item.standByTime}}</td>
            
            <td>{{item.talkTime}}</td>
            
            <td>{{item.type}}</td>
            
        </tr>
    </tbody>
</table>
