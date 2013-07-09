
<g:set var="FeatureSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
<div class="page-header">
    <h1>Feature List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        
        <th data-sortable="description">Description</th>
        
    </tr>
    </thead>
    <tbody>
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.description}}</td>
        
    </tr>
    </tbody>
</table>