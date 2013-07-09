
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
        <tr data-ng-repeat="item in list" data-ng-click="show(item)">
            
            <td>{{item.name}}</td>
            
            <td>{{item.snippet}}</td>
            
            <td>{{item.age}}</td>
            
            <td>{{item.description}}</td>
            
        </tr>
    </tbody>
</table>
