
<g:set var="AndroidSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
<div class="page-header">
    <h1>Android List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        
        <th data-sortable="os">Os</th>
        
        <th data-sortable="ui">Ui</th>
        
    </tr>
    </thead>
    <tbody>
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.os}}</td>
        
        <td>{{x.ui}}</td>
        
    </tr>
    </tbody>
</table>