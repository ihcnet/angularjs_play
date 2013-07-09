
<g:set var="CameraSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
<div class="page-header">
    <h1>Camera List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        
        <th data-sortable="cameraType">Camera Type</th>
        
    </tr>
    </thead>
    <tbody>
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.cameraType}}</td>
        
    </tr>
    </tbody>
</table>