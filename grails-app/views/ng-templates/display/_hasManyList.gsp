
<g:set var="DisplaySubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
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
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.screenResolution}}</td>
        
        <td>{{x.screenSize}}</td>
        
        <td>{{x.touchScreen}}</td>
        
    </tr>
    </tbody>
</table>