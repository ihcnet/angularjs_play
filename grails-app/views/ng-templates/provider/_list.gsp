
<div class="page-header">
    <h1>Provider List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
        <tr>
        
            <th data-sortable="name">Name</th>
            
        </tr>
    </thead>
    <tbody>
        <tr data-ng-repeat="item in list" data-ng-click="show(item)">
            
            <td>{{item.name}}</td>
            
        </tr>
    </tbody>
</table>
