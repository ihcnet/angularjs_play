
<g:set var="BatterySubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
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
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.standByTime}}</td>
        
        <td>{{x.talkTime}}</td>
        
        <td>{{x.type}}</td>
        
    </tr>
    </tbody>
</table>