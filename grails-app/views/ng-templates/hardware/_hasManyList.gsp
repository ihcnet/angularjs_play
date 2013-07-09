
<g:set var="HardwareSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
<div class="page-header">
    <h1>Hardware List</h1>
</div>
<alert level="{{message.level}}" text="{{message.text}}"/>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        
        <th data-sortable="accelerometer">Accelerometer</th>
        
        <th data-sortable="audioJack">Audio Jack</th>
        
        <th data-sortable="cpu">Cpu</th>
        
        <th data-sortable="fmRadio">Fm Radio</th>
        
        <th data-sortable="physicalKeyboard">Physical Keyboard</th>
        
        <th data-sortable="usb">Usb</th>
        
    </tr>
    </thead>
    <tbody>
    <tr data-ng-repeat="x in item.${subPrefix}">
        
        <td>{{x.accelerometer}}</td>
        
        <td>{{x.audioJack}}</td>
        
        <td>{{x.cpu}}</td>
        
        <td>{{x.fmRadio}}</td>
        
        <td>{{x.physicalKeyboard}}</td>
        
        <td>{{x.usb}}</td>
        
    </tr>
    </tbody>
</table>