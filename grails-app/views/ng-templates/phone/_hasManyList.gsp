
<g:set var="PhoneSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
<div class="page-header">
    <h1>Phone List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        
        <th data-sortable="name">Name</th>
        
        <th data-sortable="snippet">Snippet</th>
        
        <th data-sortable="age">Age</th>
        
        <th data-sortable="description">Description</th>
        
    </tr>
    </thead>
    <tbody>
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.name}}</td>
        
        <td>{{x.snippet}}</td>
        
        <td>{{x.age}}</td>
        
        <td>{{x.description}}</td>
        
    </tr>
    </tbody>
</table>