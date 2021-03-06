
<g:set var="PhoneSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>

<div class="control-group" data-ng-class="{error: errors.${PhoneSubPrefix}name}">
    <label class="control-label" for="${PhoneSubPrefix}name">Name</label>
    <div class="controls">
        <input type="text" id="name" name="name" data-ng-model="${PhoneSubPrefix}name">

        <span class="help-inline" data-ng-show="errors.${PhoneSubPrefix}name">{{errors.${PhoneSubPrefix}name}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />

<div class="control-group" data-ng-class="{error: errors.${PhoneSubPrefix}snippet}">
    <label class="control-label" for="${PhoneSubPrefix}snippet">Snippet</label>
    <div class="controls">
        <input type="text" id="snippet" name="snippet" data-ng-model="${PhoneSubPrefix}snippet">

        <span class="help-inline" data-ng-show="errors.${PhoneSubPrefix}snippet">{{errors.${PhoneSubPrefix}snippet}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />

<div class="control-group" data-ng-class="{error: errors.${PhoneSubPrefix}age}">
    <label class="control-label" for="${PhoneSubPrefix}age">Age</label>
    <div class="controls">
        <input type="number" id="age" name="age" data-ng-model="${PhoneSubPrefix}age">

        <span class="help-inline" data-ng-show="errors.${PhoneSubPrefix}age">{{errors.${PhoneSubPrefix}age}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />
<g:render template="/ng-templates/android/create" model="[subPrefix: 'os']" />

<g:render template="/ng-templates/battery/create" model="[subPrefix: 'battery']" />

<g:render template="/ng-templates/connectivity/create" model="[subPrefix: 'connectivity']" />


<div class="control-group" data-ng-class="{error: errors.${PhoneSubPrefix}description}">
    <label class="control-label" for="${PhoneSubPrefix}description">Description</label>
    <div class="controls">
        <input type="text" id="description" name="description" data-ng-model="${PhoneSubPrefix}description">

        <span class="help-inline" data-ng-show="errors.${PhoneSubPrefix}description">{{errors.${PhoneSubPrefix}description}}</span>
    </div>
</div>
<input type="Button" value="Add" ng-click="addItem(${subPrefix}, ${'[\'' + subPrefix.replaceAll('\\.', '\',\'') + '\']'})" />
<g:render template="/ng-templates/display/create" model="[subPrefix: 'display']" />

<g:render template="/ng-templates/hardware/create" model="[subPrefix: 'hardware']" />

<g:render template="/ng-templates/feature/create" model="[subPrefix: 'additionalFeature']" />

<g:render template="/ng-templates/camera/create" model="[subPrefix: 'camera']" />

<g:render template="/ng-templates/image/hasManyList" model="[subPrefix: PhoneSubPrefix + 'images']" /><g:render template="/ng-templates/image/hasManyCreate" model="[subPrefix: PhoneSubPrefix + 'images']" />

<g:render template="/ng-templates/provider/hasManyList" model="[subPrefix: PhoneSubPrefix + 'providers']" /><g:render template="/ng-templates/provider/hasManyCreate" model="[subPrefix: PhoneSubPrefix + 'providers']" />



